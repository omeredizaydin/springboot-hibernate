package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  //define a private field for the dependency
  private Coach coach;

  // define a constructor for setter injection
  @Autowired
  public DemoController(@Qualifier("cricketCoach") Coach coach) {
    System.out.println("In constructor: "+getClass().getSimpleName());
    this.coach = coach;
  }


  @GetMapping("/dailyworkout")
  public String dailyworkout() {
    return coach.getDailyWorkout();
  }




}