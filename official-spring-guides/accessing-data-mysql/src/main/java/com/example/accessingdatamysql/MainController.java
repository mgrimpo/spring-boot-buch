package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class MainController {

  @Autowired
  private UserRepository userRepository;

  @PostMapping("/add")
  public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
    User newUser = new User();
    newUser.setName(name);
    newUser.setEmail(email);
    userRepository.save(newUser);
    return "Saved";
  }

  @GetMapping("/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }

}
