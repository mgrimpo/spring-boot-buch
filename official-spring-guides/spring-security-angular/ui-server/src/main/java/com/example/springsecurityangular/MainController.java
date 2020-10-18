package com.example.springsecurityangular;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  @GetMapping("/user")
  public Principal loggedInUserHandler(Principal principal){
    return principal;
  }

}
