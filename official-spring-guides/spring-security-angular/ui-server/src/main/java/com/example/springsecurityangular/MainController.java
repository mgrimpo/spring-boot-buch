package com.example.springsecurityangular;

import com.fasterxml.jackson.databind.util.JSONPObject;
import java.security.Principal;
import java.util.Collections;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  @GetMapping("/user")
  public Principal loggedInUserHandler(Principal principal){
    return principal;
  }

  @GetMapping("/token")
  public Map<String, String> token(HttpSession session) {
    return Collections.singletonMap("token", session.getId());
  }

}


