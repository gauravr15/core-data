package com.odin.core.data.factory;

import org.springframework.beans.factory.annotation.Autowired;

import com.odin.core.data.enums.UserType;
import com.odin.core.data.service.SignUp;
import com.odin.core.data.service.impl.AgentSignUpImpl;
import com.odin.core.data.service.impl.CustomerSignUpImpl;
import com.odin.core.data.service.impl.OperatorSignUpImpl;
import com.odin.core.data.service.impl.OrganisationSignUpImpl;

public abstract class SignUpFactory {

	@Autowired
	private CustomerSignUpImpl customer;

	@Autowired
	private OrganisationSignUpImpl organisation;

	@Autowired
	private AgentSignUpImpl agent;

	@Autowired
	private OperatorSignUpImpl operator;

	SignUp getInstance(UserType userType) {
		switch (userType) {
		case CUSTOMER:
			return customer;
		case ORGANISATION:
			return organisation;
		case AGENT:
			return agent;
		case OPERATOR:
			return operator;
		default:
			return null;
		}
	}
}
