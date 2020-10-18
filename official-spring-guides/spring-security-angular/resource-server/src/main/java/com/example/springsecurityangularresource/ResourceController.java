package com.example.springsecurityangularresource;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(
    origins = "*")
@RestController
public class ResourceController {

//  @CrossOrigin(
//      origins = "*",
//      methods = {RequestMethod.OPTIONS, RequestMethod.GET},
//      allowedHeaders = {"x-auth-token", "x-requested-with", "x-xsrf-token"})
  @GetMapping("/")
  //  @CrossOrigin(
  //      origins = "*"
  //      maxAge = 3600,
  //      allowedHeaders = {"x-auth-token", "x-requested-with", "x-xsrf-token"}
  //      )
  public Message resourceHandler() {
    return new Message("Howdy from the server!");
  }
}
