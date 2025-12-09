package com.odin.core.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odin.core.data.constants.ResponseCodes;
import com.odin.core.data.dto.ResponseDTO;
import com.odin.core.data.entity.Auth;
import com.odin.core.data.entity.Profile;
import com.odin.core.data.repository.ProfileRepository;
import com.odin.core.data.service.CreateService;
import com.odin.core.data.utility.ResponseObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(value="profileService")
public class CreateCustomerServiceImpl implements CreateService<Profile> {

    @Autowired
    ResponseObject response;

    @Autowired
    private ProfileRepository profileRepo;


    @Override
    public ResponseDTO save(Profile profile) {
    	log.info("Inside customer onboard service");
        Auth newAuth = profile.getAuth();
        newAuth.setProfile(profile);
        profile.setAuth(newAuth);
        Profile savedProfile = profileRepo.save(profile);
        savedProfile.setAuth(null);
        return response.buildResponse(ResponseCodes.USER_CREATED, savedProfile);
    }

}
