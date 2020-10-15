package com.example.reactspringdatarest;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class SpringDataRestEventHandler {


  private final ManagerRepository managerRepository;


  public SpringDataRestEventHandler(
      ManagerRepository managerRepository) {
    this.managerRepository = managerRepository;
  }

  @HandleBeforeCreate
  @HandleBeforeSave
  public void applyUserInformationUsingSecurityContext(Employee employee){
    String name  = SecurityContextHolder.getContext().getAuthentication().getName();
    Manager manager = managerRepository.findByName(name);
    if (manager == null) {
      Manager newManager = new Manager();
      newManager.setName(name);
      newManager.setRoles(new String[]{"ROLE_MANAGER"});
      manager = this.managerRepository.save(newManager);
    }
    employee.setManager(manager);
  }
}
