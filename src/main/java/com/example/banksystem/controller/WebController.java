package com.example.banksystem.controller;

import com.example.banksystem.domain.Balance;
import com.example.banksystem.domain.User;
import com.example.banksystem.repository.BalanceRepository;
import com.example.banksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class WebController {
    @Autowired
    private BalanceRepository balanceRepository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping(path="/main")
    public String main(@AuthenticationPrincipal User user, Map<String, Object> model) {

        List<Balance> allIdBalances = balanceRepository.findByOwner(user);
        Balance currentBalance = allIdBalances.get(allIdBalances.size()-1);
        model.put("currentBalance", currentBalance);
        model.put("balances", allIdBalances);
        return "main";
    }

    @PostMapping(path="/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam Integer balance, Map<String, Object> model){

        Balance writtenBalance = new Balance(balance, user);
        balanceRepository.save(writtenBalance);

        return "redirect:/main";
    }

}
