package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

}
