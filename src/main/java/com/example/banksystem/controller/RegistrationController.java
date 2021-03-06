package com.example.banksystem.controller;


import com.example.banksystem.domain.Balance;
import com.example.banksystem.domain.Role;
import com.example.banksystem.domain.User;
import com.example.banksystem.repository.BalanceRepository;
import com.example.banksystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BalanceRepository balanceRepository;

    @GetMapping("/registration")
    public String registration(Map<String, Object> model){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        User userFromDB = userRepository.findByUsername(user.getUsername());
        if(userFromDB !=null){
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        Balance zeroBalance = new Balance(0, user);
        balanceRepository.save(zeroBalance);

        return "redirect:/login";

    }
}
