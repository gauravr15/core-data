package com.odin.core.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.odin.core.data.constants.LanguageConstants;
import com.odin.core.data.constants.ResponseCodes;
import com.odin.core.data.dto.ProfileDTO;
import com.odin.core.data.dto.ResponseDTO;
import com.odin.core.data.entity.Auth;
import com.odin.core.data.entity.Profile;
import com.odin.core.data.repository.AuthRepository;
import com.odin.core.data.repository.ProfileRepository;
import com.odin.core.data.service.CreateService;
import com.odin.core.data.utility.ResponseObject;
import com.odin.core.data.utility.Utility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CreateCustomerServiceImpl implements CreateService {

    @Autowired
    ResponseObject response;

    @Autowired
    private ProfileRepository profileRepo;
    
    @Autowired
    private AuthRepository authRepo;


    @Override
    public ResponseDTO save(Profile profile) {
        log.info("Inside customer onboard service");
        Auth newAuth = profile.getAuth();
        profile.setAuth(null);
        profileRepo.save(profile);
        newAuth.setCustomerId(profile.getCustomerId());
        authRepo.save(newAuth);
       return response.buildResponse(ResponseCodes.USER_CREATED, profile);
    }

}
