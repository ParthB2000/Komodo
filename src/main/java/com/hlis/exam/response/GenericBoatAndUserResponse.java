package com.hlis.exam.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class GenericBoatAndUserResponse {

	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String role;
	private Boolean isBlocked;
	private Integer numberOfBoats;

}
