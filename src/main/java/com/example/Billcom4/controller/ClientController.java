package com.example.Billcom4.controller;

import com.example.Billcom4.RepositoryLayer.ClientRepository;
import com.example.Billcom4.model.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class ClientController {
    @Autowired
     private ClientRepository clientRepository;
    @PostMapping(path="/action1")

    public  @ResponseBody int addNewClient (@RequestParam("first_name") String first_name
            , @RequestParam("name") String name, @RequestParam("cin") String cin) {
        ClientEntity n = new ClientEntity();
        n.setFirst_name(first_name);
        n.setName(name);
        n.setCin(cin);
        ClientEntity savedClient = clientRepository.save(n);
        return savedClient.getId();
    }
}
