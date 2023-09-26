package com.orm.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orm.dao.AddressDao;
import com.orm.dto.AddressDto;
import com.orm.entities.Address;

public class AddressService {

	private AddressDao addressDao;
	
	public AddressService(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	public int addAddress(AddressDto addressDto) {

		Address address = null;

		address = new Address();
		BeanUtils.copyProperties(addressDto, address);
		int addressNo = addressDao.saveAddress(address);

		return addressNo;
	}
	
	public AddressDto getAddress(int addressNo) {
		
		AddressDto addressDto = null;
		Address address = null;
		
		address = addressDao.getAddress(addressNo);
		
		addressDto = new AddressDto();
		BeanUtils.copyProperties(address, addressDto);
		
		return addressDto;
	}
	
	public List<AddressDto> getAddressByCity(String city){
		
		List<Address> addresses = null;
		List<AddressDto> addressDtos = null;
		
		addresses = addressDao.getAddressByCity(city);
		
		addresses.stream().map(address->{
			AddressDto addressDto = new AddressDto();
			BeanUtils.copyProperties(address, addressDto);
 			return addressDto;
		});
		
		return addressDtos;
	
		
	}
	
}
