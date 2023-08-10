package com.example.Billcom4.RepositoryLayer;

import com.example.Billcom4.model.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<ContractEntity, Long> {
    List<ContractEntity> findByStatus(String status);
}
