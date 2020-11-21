package com.example.springsecurityangularresource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class SpringSecurityAngularResourceApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringSecurityAngularResourceApplication.class, args);
  }

}
