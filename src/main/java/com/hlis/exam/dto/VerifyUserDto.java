package com.hlis.exam.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VerifyUserDto {

	private Integer id;
	private String token;
	private Integer otp;
}
