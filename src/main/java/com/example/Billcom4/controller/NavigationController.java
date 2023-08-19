package com.example.Billcom4.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

    @GetMapping(path = "/addClientPage")
    public String changeToAddClient (Model model){
        model.addAttribute("activePage", "addClientPage");
        return "AddClient";
    }
    @GetMapping(path = "/showClientPage")
    public String changeToEditClient (Model model){
        model.addAttribute("activePage", "showClientPage");
        return "showClients";
    }
    @GetMapping(path = "/deleteClientPage")
    public String changeToDeleteClient (Model model){
        model.addAttribute("activePage", "deleteClientPage");
        return "deleteClient";
    }
    @GetMapping(path = "/addContractPage")
    public String changeToAddContract (Model model){
        model.addAttribute("activePage", "addContractPage");
        return "AddContract";
    }
}

