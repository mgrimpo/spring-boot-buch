package com.example.reactspringdatarest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SpringDataJpaUserDetailsService implements UserDetailsService {

  private final ManagerRepository managerRepository;

  @Autowired
  public SpringDataJpaUserDetailsService(ManagerRepository managerRepository){
    this.managerRepository = managerRepository;
  }
  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    Manager manager = managerRepository.findByName(s);
    return new User(manager.getName(), manager.getPassword(), AuthorityUtils.createAuthorityList(manager.getRoles()));
  }
}
