package com.example.banksystem.controller;

import com.example.banksystem.domain.Balance;
import com.example.banksystem.domain.User;
import com.example.banksystem.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class WebController {
    @Autowired
    private BalanceRepository balanceRepository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping(path="/main")
    public String main(Map<String, Object> model){
        Iterable<Balance> balances = balanceRepository.findAll();

        model.put("balances", balances);
        return "main";
    }

    //ToDo if written balance is not a numeric value !!!

    @PostMapping(path="/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam Integer balance, Map<String, Object> model){

        Balance writtenBalance = new Balance(balance, user);
        balanceRepository.save(writtenBalance);


        Iterable<Balance> balances = balanceRepository.findAll();
        model.put("balances", balances);

        return "main";
    }

}
