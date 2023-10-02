package com.odin.core.data.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.odin.core.data.dto.SignUpDTO;
import com.odin.core.data.service.SignUp;
import com.odin.core.data.utility.ResponseObject;

@Service(value="OrganisationSignUp")
public class OrganisationSignUpImpl implements SignUp{

	@Override
	public ResponseObject signUp(HttpServletRequest request, SignUpDTO signUp) {
		// TODO Auto-generated method stub
		return null;
	}

}
