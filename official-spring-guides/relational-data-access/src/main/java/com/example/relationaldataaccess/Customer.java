package com.example.relationaldataaccess;

public class Customer {

  private long id;

  private String lastName;
  private String firstName;

  public Customer(long id, String lastName, String firstName) {
    this.id = id;
    this.lastName = lastName;
    this.firstName = firstName;
  }

  public String toString() {
    return String.format("Customer[id=%d, firstName=%s, lastName=%s]", id, firstName, lastName);
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
}
