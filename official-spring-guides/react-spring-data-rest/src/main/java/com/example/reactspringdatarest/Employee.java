package com.example.reactspringdatarest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Employee {

  @Id @GeneratedValue private Long id;

  private String firstName;
  private String lastName;
  private String description;

  @ManyToOne private Manager manager;

  private @Version @JsonIgnore Long version;

  public Employee(String firstName, String lastName, String description, Manager manager) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.description = description;
    this.manager = manager;
  }

  public Employee() {}

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "Employee{"
        + "id="
        + id
        + ", firstName='"
        + firstName
        + '\''
        + ", lastName='"
        + lastName
        + '\''
        + ", description='"
        + description
        + '\''
        + ", version"
        + version
        + '\''
        + ", manager"
        + manager
        + '\''
        + '}';
  }

  public Manager getManager() {
    return manager;
  }

  public void setManager(Manager manager) {
    this.manager = manager;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(getId(), employee.getId())
        && Objects.equals(getFirstName(), employee.getFirstName())
        && Objects.equals(getLastName(), employee.getLastName())
        && Objects.equals(getDescription(), employee.getDescription())
        && Objects.equals(getVersion(), employee.getVersion())
        && Objects.equals(getManager(), employee.getManager());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        getId(), getFirstName(), getLastName(), getDescription(), getVersion(), getManager());
  }
}
