package com.odin.core.data.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.odin.core.data.enums.UserType;
import com.sun.istack.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SignUpDTO {
	
	@NotNull
	@NotEmpty
	@NotBlank
	private UserType userType;

}
