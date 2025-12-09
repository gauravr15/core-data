package com.odin.core.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odin.core.data.constants.ResponseCodes;
import com.odin.core.data.dto.ResponseDTO;
import com.odin.core.data.entity.FileEntity;
import com.odin.core.data.repository.FileRepository;
import com.odin.core.data.service.CreateService;
import com.odin.core.data.utility.ResponseObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(value="fileService")
public class FileServiceImpl implements CreateService<FileEntity> {

    @Autowired
    ResponseObject response;

    @Autowired
    private FileRepository fileRepo;


    @Override
    public ResponseDTO save(FileEntity file) {
    	log.info("Inside customer file save service");
    	try {
    	FileEntity savedProfile = fileRepo.save(file);
        return response.buildResponse(ResponseCodes.FILE_SAVE_SUCCESSFUL, savedProfile);
    	}catch(Exception e) {
    		return response.buildResponse(ResponseCodes.FILE_SAVE_FAILURE);
    	}
    }

}
