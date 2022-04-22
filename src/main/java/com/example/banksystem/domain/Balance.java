package com.example.banksystem.domain;

import javax.persistence.*;

@Entity
public class Balance {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Integer balance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User owner;

    public Balance() {
    }

    public Balance(Integer balance, User user) {
        this.balance = balance;
        this.owner = user;
    }

    public User getOwner() {
        return owner;
    }

    public String getOwnerName() {
        return  owner != null ? owner.getUsername() : "<none>";
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }


}
