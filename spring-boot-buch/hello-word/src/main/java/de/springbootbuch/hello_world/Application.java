package de.springbootbuch.hello_world;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {
  public static void main(String... args) {
    SpringApplication.run(Application.class);
  }

  @RestController
  public static class HelloWorldController {
    @GetMapping("/hello")
    public String helloWorld(@RequestParam final String name) {
      return String.format("Hello, %s\n",name);
    }

  }

}

