package com.odin.core.data.service;

import com.odin.core.data.dto.ResponseDTO;

public interface CreateService<T> {
	
	ResponseDTO save(T profile);
}
