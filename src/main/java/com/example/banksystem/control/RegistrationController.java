package com.example.banksystem.control;

import com.example.banksystem.entities.User;
import com.example.banksystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;
    
    
    @GetMapping("/registration")
    public String registration(Map<String, Object> model){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam String username, @RequestParam String password,
            Map<String, Object> model){
        User userFromDB = userRepository.findByUsername(username);
        if(userFromDB != null){
            return "login";
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
        return "redirect:/login";
    }

}
