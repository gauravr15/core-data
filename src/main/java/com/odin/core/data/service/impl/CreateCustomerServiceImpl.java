package com.odin.core.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
    private Utility utility;

    @Autowired
    ResponseObject response;

    @Autowired
    private ProfileRepository profileRepo;

    @Autowired
    private AuthRepository authRepo;

    @Override
    public ResponseDTO onboard(ProfileDTO profile) {
        log.info("Inside customer onboard service");

        // Convert DTO to Profile entity
        Profile customerProfile = utility.dtoToEntity(profile, Profile.class);
        Auth customerAuth = customerProfile.getAuth();
        customerProfile.setAuth(null);
        Profile checkProfile = profileRepo.findByMobileAndIdNum(profile.getMobile(), profile.getIdNum());

        if (!ObjectUtils.isEmpty(checkProfile)) {
            log.error("Customer already exists with customer id: {}", checkProfile.getCustomerId());
            return response.buildResponse(ResponseCodes.USER_EXISTS);
        } else {
            log.info("Creating new customer");

            // Save the Profile entity first to generate the customerId
            customerProfile.setAuth(null);
            Profile savedProfile = profileRepo.save(customerProfile);
            // Create and assign the Auth entity with the same customerId
            customerAuth.setCustomerId(savedProfile.getCustomerId());

            // Save the Auth entity
            authRepo.save(customerAuth);

            // Return response
            return response.buildResponse(ResponseCodes.USER_CREATED, savedProfile);
        }
    }

}
