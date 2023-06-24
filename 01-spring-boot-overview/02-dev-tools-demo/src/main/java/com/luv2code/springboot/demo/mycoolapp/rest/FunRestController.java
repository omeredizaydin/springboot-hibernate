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
    return "1-) Trainer: "+name+" Team: "+team;
  }
  // expose a new endpoint for "workout"
  @GetMapping("workout")
  public String getDailyWorkout(){
    return "run a hard 5k!!";
  }
  // expose a new endpoint for "fortune"
  @GetMapping("fortune")
  public String getDailyFortune(){
    return "Today is your lucky day";
  }
}
