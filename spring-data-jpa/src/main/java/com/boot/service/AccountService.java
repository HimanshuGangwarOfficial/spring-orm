package com.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.entities.Account;
import com.boot.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Transactional(readOnly = false)
	public void saveAccount(Account account) {

		accountRepository.save(account);
	}
}
