package com.example.Billcom4.controller;

import com.example.Billcom4.RepositoryLayer.ContractRepository;
import com.example.Billcom4.ServiceLayer.ContractService;
import com.example.Billcom4.model.ClientEntity;
import com.example.Billcom4.model.ContractEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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
    @PostMapping(path="/addingContract")
    public  String addNewContract (@RequestParam("number") String number
            ,  @RequestParam("status") String status, HttpSession session) {
        ContractEntity n = new ContractEntity();
        n.setStatus(status);
        n.setNumber(number);
        n.setClientid(0);
        ContractEntity savedContract = contractRepository.save(n);
        return "fragments/contractAdded";
    }
    @GetMapping(path="/allcontracts")
    public @ResponseBody Iterable<ContractEntity> getAllContracts() {
        return contractRepository.findAll();
    }
    @DeleteMapping(path="/contract/{id}")
    public ResponseEntity<String> deleteContract(@PathVariable int id) {
        try {
            contractRepository.deleteById((long) id);
            return ResponseEntity.ok("Contract deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting contract");
        }
    }
    @GetMapping("/contract/edit/{contractid}")
    public @ResponseBody
    ContractEntity getClientById(@PathVariable String contractid) {
        Optional<ContractEntity> optionalContract = contractRepository.findById(Long.parseLong(contractid));
        return optionalContract.orElse(null);
    }
    @PutMapping("/updateContract/{contractid}")
    public ResponseEntity<String> updateContract(@PathVariable String contractid, @RequestBody ContractEntity updatedClient) {
        Optional<ContractEntity> existingClientOptional = contractRepository.findById(Long.parseLong(contractid));

        if (existingClientOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Update the existing client with new data
        ContractEntity existingClient = existingClientOptional.get();
        existingClient.setClientid(updatedClient.getClientid());
        existingClient.setNumber(updatedClient.getNumber());
        existingClient.setStatus(updatedClient.getStatus());

        contractRepository.save(existingClient);

        return ResponseEntity.ok("Client information updated successfully");
    }
}
