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
    public String changeToShowClient (Model model){
        model.addAttribute("activePage", "showClientPage");
        return "showClients";
    }
    @GetMapping(path = "/showContractsPage")
    public String changeToshowContracts (Model model){
        model.addAttribute("activePage", "showContractsPage");
        return "showContracts";
    }
    @GetMapping(path = "/addContractPage")
    public String changeToAddContract (Model model){
        model.addAttribute("activePage", "addContractPage");
        return "AddContract";
    }
    @GetMapping(path = "/editClient")
    public String changeToEditClient (Model model){
        model.addAttribute("activePage", "editClientPage");
        return "EditClient";
    }
    @GetMapping(path = "/editContract")
    public String changeToEditContract (Model model){
        model.addAttribute("activePage", "editContractPage");
        return "EditContract";
    }
}

