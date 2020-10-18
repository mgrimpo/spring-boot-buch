package com.example.springsecurityangular;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringSecurityAngularApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringSecurityAngularApplication.class, args);
  }
}
