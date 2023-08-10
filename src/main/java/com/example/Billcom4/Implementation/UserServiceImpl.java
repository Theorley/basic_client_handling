package com.example.Billcom4.Implementation;

import com.example.Billcom4.RepositoryLayer.UserRepository;
import com.example.Billcom4.ServiceLayer.UserService;
import com.example.Billcom4.model.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public boolean authenticateUser(String username, String password) {
        UserEntity user = userRepository.findByUsername(username);
        if (user != null && (password.equals(user.getPassword()))) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void updatePassword(String username, String newPassword) {
        UserEntity user = userRepository.findByUsername(username);
        if (user != null) {
            user.setPassword(newPassword);
            userRepository.save(user);
        }
    }
}

