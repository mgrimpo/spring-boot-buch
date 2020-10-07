package com.example.testingweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

  @Autowired
  private GreetingService greetingService;

  @GetMapping("/greeting")
  public @ResponseBody String greetingHandler(){
    return greetingService.greet();
  }

}
