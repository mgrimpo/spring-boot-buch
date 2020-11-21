package com.example.springsecurityangular.authserver;

import java.security.Principal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

  @RequestMapping("/user")
  public Principal userHandler(Principal user){
    return user;
  }


}
