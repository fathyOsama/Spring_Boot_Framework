package com.luv2code.springboot.demo.mycoolapp.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    private static final Logger log = LoggerFactory.getLogger(FunRestController.class);
    // inject properties for : coach name and team name
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    // expose new endpoint for "teaminfo"
    @GetMapping("/teaminfo")
    public String teaminfo(){
         return "coach :" + coachName +" , team :" + teamName;
    }

    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String getDailyworkout(){
        return "Run a hard 5k!";
    }

    @GetMapping("/Fortune")
    public String getDailyFortune(){
        return "Today is your lucky day";
    }


}
