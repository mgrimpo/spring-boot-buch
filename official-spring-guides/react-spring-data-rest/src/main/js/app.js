import {ButtonGroup} from "react-bootstrap";

const React = require('react')
const ReactDOM = require('react-dom')
const client = require('./client')
const follow = require('./follow')
const {Modal} = require('react-bootstrap')
const {Button} = require('react-bootstrap')
const {Container} = require('react-bootstrap')

const API_ROOT = "/api";

class App extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      employees: [],
      pageSize: 2,
      attributes: [],
      links: []
    };

    this.onCreate = this.onCreate.bind(this);
  }

  componentDidMount() {
    this.loadFromServer(this.state.pageSize);
  }

  render() {
    return (
        <Container className="border-left border-right h-100 p-5">
          <h1 className="mb-4">Employee Management App</h1>
          <CreateDialog attributes={this.state.attributes}
                        onCreate={this.onCreate}/>
          <EmployeeList employees={this.state.employees}/>
        </Container>);
  }

  loadFromServer(pageSize) {
    follow(client, API_ROOT, [
      {rel: 'employees', params: {size: pageSize}}]
    ).then(employeeCollection => {
      return client({
        method: 'GET',
        path: employeeCollection.entity._links.profile.href,
        headers: {'Accept': 'application/schema+json'}
      }).then(schema => {
        this.schema = schema.entity;
        return employeeCollection;
      });
    }).done(employeeCollection => {
      this.setState({
        employees: employeeCollection.entity._embedded.employees,
        attributes: Object.keys(this.schema.properties),
        pageSize: pageSize,
        links: employeeCollection.entity._links
      });
    });
  }

  onCreate(newEmployee) {
    follow(client, API_ROOT, ['employees']).then(employeeCollection => {
      return client({
        method: 'POST',
        path: employeeCollection.entity._links.self.href,
        entity: newEmployee,
        headers: {'Content-Type': 'application/json'}
      })
    }).then(response => {
      return follow(client, API_ROOT, [
        {rel: 'employees', params: {'size': this.state.pageSize}}]);
    }).done(response => {
      if (typeof response.entity._links.last !== "undefined") {
        this.onNavigate(response.entity._links.last.href);
      } else {
        this.onNavigate(response.entity._links.self.href);
      }
    });
  }

}

class CreateDialog extends React.Component {

  constructor(props) {
    super(props);
    this.attributeRefs = {};
    this.state = {
      show: false
    }
    this.handleSubmit = this.handleSubmit.bind(this);
    this.toggle = this.toggle.bind(this);
  }

  handleSubmit(event) {
    event.preventDefault();
    const newEmployee = {};
    this.props.attributes.forEach(attribute => {
      newEmployee[attribute] = this.attributeRefs[attribute].current.value.trim()
    })
    this.props.onCreate(newEmployee);
    this._clearInputElements();
    this._closeDialog();
  }

  toggle() {
    this.setState({show: !this.state.show})
  }

  render() {
    const inputs = this.props.attributes.map(
        attribute => (
            <p className="form-group" key={attribute}>
              <input type="text" placeholder={attribute}
                     ref={this.newAttributeRef(attribute)}
                     className="form-control"/>
            </p>))
    return (
        <div>
          <Button variant="primary" onClick={this.toggle} className="my-2">
            Create new Employee
          </Button>
          <Modal show={this.state.show} onHide={this.toggle}>
            <Modal.Header closeButton>
              <Modal.Title>Create Employee </Modal.Title>
            </Modal.Header>
            <Modal.Body>
              {inputs}
              <Button onClick={this.handleSubmit}>Create</Button>
            </Modal.Body>
          </Modal>
        </div>);
    // <div>
    //   <a href="#createEmployee" data-target="#createEmployee" data-toggle="modal" >Create</a>
    //   <div id="createEmployee" className="modal fade" role="dialog">
    //   <div className="modal-dialog " role="document">
    //     <div className="modal-content">
    //       <div className="modal-header">
    //         <h2 className="modal-title">Create new employee</h2>
    //         <a href="#" title="Close" className="close" data-dismiss="modal" >X</a>
    //       </div>
    //       <div className="modal-body">
    //         <form>
    //           {inputs}
    //           <button onClick={this.handleSubmit} data-dismiss="modal">Create</button>
    //         </form>
    //       </div>
    //     </div>
    //   </div>
    //   </div>
    // </div>)
  }

  newAttributeRef(attribute) {
    const result = React.createRef();
    this.attributeRefs[attribute] = result;
    return result;
  }

  _clearInputElements() {
    this.props.attributes.forEach(
        attribute => this.attributeRefs[attribute].current.value = '')
  }

  _closeDialog() {
    window.location = "#";
  }
}

class EmployeeList extends React.Component {
  render() {
    const employeeComponents = this.props.employees.map(
        employee => <Employee key={employee._links.self.href}
                              employee={employee}/>
    );
    return (
        <div className="mt-4">
          <h4>List of employees</h4>
          <table className="table my-2">
            <tbody>
            <tr>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Description</th>
            </tr>
            {employeeComponents}
            </tbody>
          </table>
        </div>
    );
  }
}

class Employee extends React.Component {
  render() {
    return (
        <tr>
          <td>{this.props.employee.firstName}</td>
          <td>{this.props.employee.lastName}</td>
          <td>{this.props.employee.description}</td>
        </tr>
    )
  }
}

ReactDOM.render(<App/>, document.getElementById("react"));
