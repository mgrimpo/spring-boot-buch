package com.example.springsecurityangularresource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

  @GetMapping("/")
  @CrossOrigin(
      origins = "http://localhost:8080",
      maxAge = 3600,
      allowedHeaders = {"x-auth-token", "x-requested-with", "x-xsrf-token"})
  public Message resourceHandler() {
    return new Message("Howdy from the server!");
  }
}
