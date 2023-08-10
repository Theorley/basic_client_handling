package com.example.Billcom4.ServiceLayer;

public interface UserService {
    boolean authenticateUser(String username, String password);
    void updatePassword(String username, String newPassword);



}
