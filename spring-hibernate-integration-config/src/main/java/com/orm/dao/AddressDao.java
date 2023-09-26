package com.orm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.orm.entities.Address;

public class AddressDao {

	private HibernateTemplate hibernateTemplate;
	
	public AddressDao(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public int saveAddress(Address address) {
		int addressNo = (int) hibernateTemplate.save(address);
		return addressNo;
	}

	public Address getAddress(int addressNo) {
		return hibernateTemplate.get(Address.class, addressNo);
	}

	public List<Address> getAddressByCity(String city) {
		return (List<Address>) hibernateTemplate.findByNamedQuery("from Address address where city = :city", "city",
				city);
	}

}
