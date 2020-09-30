package com.example.springbootexample;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BuildingSpringBootApplicationExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuildingSpringBootApplicationExampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner inspectBeanCommandLineRunner(ApplicationContext ctx){
    return args -> {
      System.out.println("Inspecting beans loaded in Spring Context:");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			Arrays.stream(beanNames).forEach(System.out::println);
    };
	}

}
