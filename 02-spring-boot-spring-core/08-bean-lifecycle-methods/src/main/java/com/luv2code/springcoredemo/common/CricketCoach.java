package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
  public CricketCoach() {
    System.out.println("In constructor: " + getClass().getSimpleName());

  }

  // define our init method
  @PostConstruct
  public void doMyStartupStaff(){
    System.out.println("In my doMyStartupStuff(): "+getClass().getSimpleName());
  }

  // define our destroy method

  @PreDestroy
  public void doMyCleanupStaff(){
    System.out.println("In my doMyCleanupStaff(): "+getClass().getSimpleName());

  }
  @Override
  public String getDailyWorkout() {
    return "Practice fast bowling for 15 minutes :)";
  }


}
