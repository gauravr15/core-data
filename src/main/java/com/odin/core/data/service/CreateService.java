package com.odin.core.data.service;

import com.odin.core.data.dto.ProfileDTO;
import com.odin.core.data.dto.ResponseDTO;

public interface CreateService {

	public ResponseDTO onboard(ProfileDTO profile);
}
