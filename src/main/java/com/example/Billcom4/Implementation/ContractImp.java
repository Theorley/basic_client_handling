package com.example.Billcom4.Implementation;
import com.example.Billcom4.RepositoryLayer.ContractRepository;
import com.example.Billcom4.ServiceLayer.ContractService;
import com.example.Billcom4.model.ContractEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractImp implements ContractService {

    private final ContractRepository contractRepository;
    @Autowired
    public ContractImp(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }
    @Override
    public String  assignContract(int client_id) {
        List<ContractEntity> contracts_available= contractRepository.findByStatus("unactive");
        if (contracts_available.isEmpty()) {
            return  "FAILED OPERATION";
        }
        else {
            ContractEntity c = contracts_available.get(0);
            c.setClient_id(client_id);
            c.setStatus("active");
            contractRepository.save(c);
            return "updated";
        }
    }
}
