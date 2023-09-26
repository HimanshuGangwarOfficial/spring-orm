package com.boot.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boot.entities.Account;
import com.boot.entities.Address;
import com.boot.service.AccountService;
import com.boot.service.AddressService;

@Component
public class AccountController {
	
	@Autowired
	AccountService accountService;

	public void insertAccount() {

		Address address = new Address();
		address.setAddressLine1("Suresh Sharma Nagar");
		address.setAddressLine2("Behind of Mega City");
		address.setCity("Bareilly");
		address.setCountry("India");
		address.setState("UP");
		address.setZip(243005);
		Set<Address> addresses = new HashSet<>();
		addresses.add(address);

		Account account = new Account();
		account.setAccountHolderName("Himanshu Gangwar");
		account.setAccountType("Saving");
		account.setBalance(20000.0);
		account.setAddresses(addresses);
		
		accountService.saveAccount(account);

	}
}
