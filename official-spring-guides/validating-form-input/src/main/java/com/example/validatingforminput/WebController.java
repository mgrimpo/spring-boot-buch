package com.example.validatingforminput;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class WebController implements WebMvcConfigurer {

  @Override
  public void addViewControllers(ViewControllerRegistry viewControllerRegistry){
    viewControllerRegistry.addViewController("/results").setViewName("results");
  }

  @GetMapping("/")
  public String showForm(@ModelAttribute PersonForm personForm){
    return "form";
  }

  @PostMapping("/")
  public String validateForm(@Valid PersonForm personForm, BindingResult bindingResult) {
    if (bindingResult.hasErrors()){
      return "form";
    }
    return "redirect:/results";
  }

}
