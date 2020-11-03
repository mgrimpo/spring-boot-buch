package com.example.springsecurityangular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class SpringSecurityAngularApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringSecurityAngularApplication.class, args);
  }

  @Bean
  public HttpTraceRepository htttpTraceRepository()
  {
    return new InMemoryHttpTraceRepository();
  }
}
