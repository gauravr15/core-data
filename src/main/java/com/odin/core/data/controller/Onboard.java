package com.odin.core.data.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

import com.odin.core.data.constants.APIConstants;
import com.odin.core.data.dto.SignUpDTO;
import com.odin.core.data.service.UserSignUpService;
import com.odin.core.data.utility.ResponseObject;

@Slf4j
@RestController
@RequestMapping(value = APIConstants.SIGNUP)
public class Onboard {

	@Autowired
	private UserSignUpService userSignUp;

	@GetMapping
	public ResponseEntity<Object> signUp(HttpServletRequest request, SignUpDTO data) {
		log.info("Inside signup api");
		ResponseObject response = userSignUp.verifyAndProceedSignup(request, data);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
}
