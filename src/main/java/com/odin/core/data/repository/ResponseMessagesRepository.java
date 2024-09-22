package com.odin.core.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.odin.core.data.entity.ResponseMessages;

@Repository
public interface ResponseMessagesRepository extends JpaRepository<ResponseMessages, Integer> {

}
