package com.example.Billcom4.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

    @GetMapping(path = "/addClientPage")
    public String changeToAddClient (){
        return "home";
    }
    @GetMapping(path = "/editClientPage")
    public String changeToEditClient (){
        return "home";
    }
    @GetMapping(path = "/deleteClientPage")
    public String changeToDeleteClient (){
        return "home";
    }
}

