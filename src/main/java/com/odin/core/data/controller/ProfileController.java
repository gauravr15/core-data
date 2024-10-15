package com.odin.core.data.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odin.core.data.constants.ApplicationConstants;
import com.odin.core.data.dto.ResponseDTO;
import com.odin.core.data.entity.Profile;
import com.odin.core.data.service.CreateService;

@RestController
@RequestMapping(value = ApplicationConstants.API_VERSION)
public class ProfileController {
	
	@Autowired
	private CreateService createService;
	
	@PostMapping(ApplicationConstants.CUSTOMER + ApplicationConstants.SAVE)
	public ResponseEntity<Object> createCustomer(HttpServletRequest servlet, @RequestBody Profile profileDTO ){
		ResponseDTO response = createService.save(profileDTO);
		return new ResponseEntity<>(response, HttpStatus.OK); 
	}
}
