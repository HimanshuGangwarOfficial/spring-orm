package com.orm.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.orm.config.RootConfig;
import com.orm.dto.AddressDto;
import com.orm.service.AddressService;

public class SpringHibIntegrationTest {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfig.class);

		AddressService addressService = applicationContext.getBean("addressService", AddressService.class);

		AddressDto addressDto = AddressDto.builder().addressLine1("Suresh Sharma Nagar").addressLine2("Bareilly").city("Bareilly")
				.state("Uttar Pradesh").country("India").zip("243005").build();

		int addressNo = addressService.addAddress(addressDto);
		System.out.println(addressNo);
		
		AddressDto address = addressService.getAddress(addressNo);
		System.out.println(address);
		
		
	}
}
