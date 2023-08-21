package com.example.Billcom4.controller;
import com.example.Billcom4.RepositoryLayer.UserRepository;
import com.example.Billcom4.ServiceLayer.UserService;
import com.example.Billcom4.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path="/add")
    public  String addNewUser (@RequestParam("username") String username
            , @RequestParam("password") String password, Model model) {
        UserEntity n = new UserEntity();
        n.setUsername(username);
        n.setPassword(password);
        userRepository.save(n);
        model.addAttribute("message", "User added successfully!");
        return "index";
    }
    @PostMapping(path="/login")
    public String loginRequest(@RequestParam String username , @RequestParam String password, Model model){
        if (userService.authenticateUser(username, password)) {
            model.addAttribute("activePage", "addClientPage");
            return "AddClient";
        } else {
            return "successv2";
        }
    }
    @GetMapping(path="/return")
    public String change1(){
        return "register";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
