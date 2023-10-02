package com.odin.core.data.service;

import javax.servlet.http.HttpServletRequest;

import com.odin.core.data.dto.SignUpDTO;
import com.odin.core.data.utility.ResponseObject;

public interface UserSignUpService {
	
	ResponseObject verifyAndProceedSignup(HttpServletRequest request, SignUpDTO signup);

}
