package com.example.Billcom4.controller;

import com.example.Billcom4.RepositoryLayer.ContractRepository;
import com.example.Billcom4.ServiceLayer.ContractService;
import com.example.Billcom4.model.ContractEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContractController {
    private final ContractService contractService;
    @Autowired
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }
    @Autowired
    public ContractRepository contractRepository;
    @PutMapping(path="/action2")
    public  @ResponseBody String updateContract(@RequestParam ("clientId") int clientId){
        String output = contractService.assignContract (clientId);
        return "assignmentGreat";
    }
    @GetMapping(path="/addClient")
    public String change(HttpSession session, Model model){
        String formData = (String) session.getAttribute("formData").toString();
        List<ContractEntity> listNumber= contractRepository.findByClientid(Integer.parseInt(formData));
        ContractEntity contract=listNumber.get(0);
        model.addAttribute("formData", contract.getNumber());
        return "assignmentGreat";
    }

}
