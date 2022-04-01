package com.example.banksystem.domain;

import javax.persistence.*;

@Entity
public class Balance {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Integer balance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Balance() {
    }

    public Balance(Integer balance, User user) {
        this.balance = balance;
        this.author = user;
    }

    public String getAuthorName() {
        return  author != null ? author.getUsername() : "<none>";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

}
