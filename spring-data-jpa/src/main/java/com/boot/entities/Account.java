package com.boot.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "account")
@Data
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_no")
	int accountNo;
	@Column(name = "account_holder_name")
	String accountHolderName;
	@Column(name = "account_type")
	String accountType;
	double balance;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
	Set<Address> addresses;
}
