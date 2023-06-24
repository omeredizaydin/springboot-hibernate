package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  //define a private field for the dependency
  private Coach coach;

  // define a constructor for setter injection
  @Autowired
  public void setCoach(Coach coach){
    this.coach = coach;
  }

  @GetMapping("dailyworkout")
  public String dailyworkout(){
    return coach.getDailyWorkout();
  }


}
