package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In constructor "+ getClass().getSimpleName());
    }

    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In  doMyStartupStuff: "+ getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyCleanStuff(){
        System.out.println("In  doMyCleanStuff: "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
