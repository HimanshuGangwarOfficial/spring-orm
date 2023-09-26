package com.boot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_no")
	int addressNo;
	@Column(name = "address_line1")
	String addressLine1;
	@Column(name = "address_line2")
	String addressLine2;
	String city;
	String state;
	int zip;
	String country;


	@ManyToOne
	@JoinColumn(name="account_no")
	Account account;
}
