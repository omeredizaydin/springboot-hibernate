package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

  @Value("${coach.name}")
  private String name;
  @Value("${coach.team}")
  private String team;
  @GetMapping("/")
  public String helloWorld(){
    return "Trainer: "+name+" Team: "+team;
  }
}
