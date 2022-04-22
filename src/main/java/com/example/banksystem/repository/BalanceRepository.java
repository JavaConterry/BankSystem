package com.example.banksystem.repository;

import com.example.banksystem.domain.Balance;
import com.example.banksystem.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface BalanceRepository extends CrudRepository<Balance, Long> {
    List<Balance> findByOwner(User owner);
}
