package com.odin.core.data.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.odin.core.data.dto.ProfileDTO;
import com.odin.core.data.service.CreateService;
import com.odin.core.data.service.impl.CreateCustomerServiceImpl;

@Component
public class CustomerFactory {
	
	@Autowired
	CreateCustomerServiceImpl customer;
	
	public CreateService getInstance(ProfileDTO profile) {
		switch(profile.getCustomerType()) {
		case CUSTOMER:
			return customer;
		default:
			return null;
		}
	}

}
