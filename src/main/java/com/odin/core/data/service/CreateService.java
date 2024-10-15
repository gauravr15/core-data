package com.odin.core.data.service;

import com.odin.core.data.dto.ResponseDTO;
import com.odin.core.data.entity.Profile;

public interface CreateService {
	
	ResponseDTO save(Profile profile);
}
