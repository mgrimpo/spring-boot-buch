package com.example.reactspringdatarest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Arrays;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
public class Manager {

  public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

  @Id
  @GeneratedValue
  private Long id;

  @JsonIgnore
  private String password;

  private String name;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Manager manager = (Manager) o;
    return Objects.equals(getId(), manager.getId()) &&
        Objects.equals(getPassword(), manager.getPassword()) &&
        Objects.equals(getName(), manager.getName()) &&
        Arrays.equals(getRoles(), manager.getRoles());
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(getId(), getPassword(), getName());
    result = 31 * result + Arrays.hashCode(getRoles());
    return result;
  }

  public Manager(String name, String password, String... roles) {
    this.name = name;
    this.setPassword(password);
    this.roles = roles;
  }

  public void setPassword(String password) {
    this.password = PASSWORD_ENCODER.encode(password);
  }

  public String getPassword() {
    return password;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String[] getRoles() {
    return roles;
  }

  public void setRoles(String[] roles) {
    this.roles = roles;
  }

  private String[] roles;

  protected Manager(){}

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }
}
