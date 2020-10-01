package com.example.validatingforminput;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class PersonForm {

  @NotNull
  @Size(min=2,max=30)
  private String name;

  @NotNull
  @Min(18)
  private int age;

  @Override
  public String toString() {
    return "PersonForm{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
