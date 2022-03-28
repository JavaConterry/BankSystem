package com.example.banksystem.entities;

import javax.persistence.*;

@Entity
public class Balance {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @JoinColumn(name="user_id")
    private Long balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

}
