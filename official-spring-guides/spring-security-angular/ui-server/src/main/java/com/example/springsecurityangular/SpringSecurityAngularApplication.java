package com.example.springsecurityangular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SpringSecurityAngularApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringSecurityAngularApplication.class, args);
  }
}
