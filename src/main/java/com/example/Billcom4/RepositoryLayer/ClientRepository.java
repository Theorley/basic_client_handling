package com.example.Billcom4.RepositoryLayer;

import com.example.Billcom4.model.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<ClientEntity, Integer> {
    Optional<ClientEntity> findByCin(String cin);
}
