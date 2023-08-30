package com.example.Billcom4.controller;

import com.example.Billcom4.RepositoryLayer.ClientRepository;
import com.example.Billcom4.model.ClientEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ClientController {
    @Autowired
     private ClientRepository clientRepository;
    @PostMapping(path="/action1")

    public  @ResponseBody int addNewClient (@RequestParam("first_name") String first_name
            , @RequestParam("name") String name, @RequestParam("cin") String cin, HttpSession session) {
        ClientEntity n = new ClientEntity();
        n.setFirst_name(first_name);
        n.setName(name);
        n.setCin(cin);
        ClientEntity savedClient = clientRepository.save(n);
        session.setAttribute("formData", savedClient.getId());
        return savedClient.getId();
    }
    @GetMapping(path="/allclients")
    public @ResponseBody Iterable<ClientEntity> getAllClients() {
        return clientRepository.findAll();
}
    @DeleteMapping(path="/client/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable int id) {
        try {
            clientRepository.deleteById(id);
            return ResponseEntity.ok("Client deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting client");
        }
    }


    @GetMapping("/client/edit/{cin}")
    public @ResponseBody
    ClientEntity getClientByCIN(@PathVariable String cin) {
        Optional<ClientEntity> optionalClient = clientRepository.findByCin(cin);
        return optionalClient.orElse(null);
    }
    @PutMapping("/updateClient/{cin}")
    public ResponseEntity<String> updateClient(@PathVariable String cin, @RequestBody ClientEntity updatedClient) {
        Optional<ClientEntity> existingClientOptional = clientRepository.findByCin(cin);

        if (existingClientOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Update the existing client with new data
        ClientEntity existingClient = existingClientOptional.get();
        existingClient.setFirst_name(updatedClient.getFirst_name());
        existingClient.setName(updatedClient.getName());
        existingClient.setCin(updatedClient.getCin());

        clientRepository.save(existingClient);

        return ResponseEntity.ok("Client information updated successfully");
    }
}


