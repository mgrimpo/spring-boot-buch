package com.example.springsecurityangularresource;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

  @GetMapping("/")
  @CrossOrigin(origins="http://localhost:8080", maxAge=3600)
  public Message resourceHandler(){
    return new Message("Howdy from the server!");
  }
}
