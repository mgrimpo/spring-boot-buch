package com.example.springsecurityangular.authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
public class AuthServerApplication extends WebMvcConfigurerAdapter {

  public static void main(String[] args) {
    SpringApplication.run(AuthServerApplication.class, args);
  }
}
