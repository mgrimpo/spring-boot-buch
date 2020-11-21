package com.example.springsecurityangularresource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

  @GetMapping("/")
  public Message resourceHandler() {
    return new Message("Howdy from the server!");
  }
}
