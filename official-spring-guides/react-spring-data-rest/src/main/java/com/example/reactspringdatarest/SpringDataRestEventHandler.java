package com.example.reactspringdatarest;

import java.util.Optional;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class SpringDataRestEventHandler {


  private final ManagerRepository managerRepository;

  private final EmployeeRepository employeeRepository;


  public SpringDataRestEventHandler(
      ManagerRepository managerRepository,
      EmployeeRepository employeeRepository) {
    this.managerRepository = managerRepository;
    this.employeeRepository = employeeRepository;
  }

  @HandleBeforeCreate
  @HandleBeforeSave
  public void applyUserInformationUsingSecurityContext(Employee employee){
    String authenticatedName  = SecurityContextHolder.getContext().getAuthentication().getName();
    Manager authenticatedManager = managerRepository.findByName(authenticatedName);
    if (employee.getId() == null ||
        isEmployeePersistedAndHasAuthenticatedManager(employee.getId(), authenticatedName)){
      employee.setManager(authenticatedManager);
    }
  }

  private boolean isEmployeePersistedAndHasAuthenticatedManager(Long employeeId,
      String authenticatedName) {
    Optional<Employee> employeeInDb = employeeRepository.findById(employeeId);
    return employeeInDb
        .map(Employee::getManager)
        .map(Manager::getName)
        .map(managerInDb -> managerInDb.equals(authenticatedName))
        .orElse(false);
  }
}
