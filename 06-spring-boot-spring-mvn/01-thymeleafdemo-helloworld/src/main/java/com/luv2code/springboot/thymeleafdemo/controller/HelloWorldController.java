package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // need a controller method to show initial HTML form
    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    // need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(){
    return "helloworld";
    }

    // need a controller method to read form data and
    // add data to the model
    @PostMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){
       // read the request parameter form the HTML form
        String theName = request.getParameter("studentName");

       // convert the data to all caps
       theName = theName.toUpperCase();

       // create the message
        String result = "Yo! " + theName;

       // add massage to the model
        model.addAttribute("message", result);


        return "helloworld";

    }

    @RequestMapping("/processFormVersionThree")
    public String processFromVersionThree(@RequestParam("studentName")String theName,
                                          Model model){

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Hey My Friend from v3 " + theName;

        // add massage to the model
        model.addAttribute("message", result);


        return "helloworld";

    }


}
