package com.example.Billcom4.RepositoryLayer;

import com.example.Billcom4.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
}
