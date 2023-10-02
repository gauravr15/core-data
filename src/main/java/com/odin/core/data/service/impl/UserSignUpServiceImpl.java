package com.odin.core.data.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.odin.core.data.dto.SignUpDTO;
import com.odin.core.data.service.UserSignUpService;
import com.odin.core.data.utility.ResponseObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserSignUpServiceImpl implements UserSignUpService{
	
	@Override
	public ResponseObject verifyAndProceedSignup(HttpServletRequest request, SignUpDTO signup) {
		
		return null;
	}

}
