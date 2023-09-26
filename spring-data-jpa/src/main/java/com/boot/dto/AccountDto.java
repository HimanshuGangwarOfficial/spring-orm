package com.boot.dto;

import java.util.Set;

import com.boot.entities.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

	int accountNo;
	String accountHolderName;
	String accountType;
	double balance;
	Set<Address> addresses;
}
