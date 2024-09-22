package com.odin.core.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.odin.core.data.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long>{
	
	public Profile findByMobileAndIdNum(String mobile, String idNum);
}
