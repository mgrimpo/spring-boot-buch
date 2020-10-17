package com.example.springsecurityangular;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  @GetMapping("/resource")
  public Map<String, Object> resourceHandler(){
    Map<String, Object> model = new HashMap<>();
    model.put("id", UUID.randomUUID().toString());
    model.put("content", "Hello from the server");
    return model;
  }

  @GetMapping("/user")
  public Principal loggedInUserHandler(Principal principal){
    return principal;
  }

}
