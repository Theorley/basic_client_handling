package com.example.Billcom4.controller;

import com.example.Billcom4.ServiceLayer.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContractController {
    private final ContractService contractService;
    @Autowired
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }
    @PutMapping(path="/action2")
    public  @ResponseBody String updateContract(@RequestParam ("clientId") int clientId){
        String output = contractService.assignContract (clientId);
        return "assignmentGreat";
    }
    @GetMapping(path="/addClient")
    public String change(){
        return "assignmentGreat";
    }
}
