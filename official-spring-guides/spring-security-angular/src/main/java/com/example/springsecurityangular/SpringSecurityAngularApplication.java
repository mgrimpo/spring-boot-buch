package com.example.springsecurityangular;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringSecurityAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAngularApplication.class, args);
	}

	@GetMapping("/resource")
  public Map<String, Object> resourceHandler(){
	  Map<String, Object> model = new HashMap<>();
	  model.put("id", UUID.randomUUID().toString());
    model.put("content", "Hello from the server");
	  return model;
  }

}
