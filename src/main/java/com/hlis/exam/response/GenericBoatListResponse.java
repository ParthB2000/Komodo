package com.hlis.exam.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonInclude(Include.NON_NULL)
public class GenericBoatListResponse {

	private Integer id;
	private String name;
	private String size;
	private Long capacity;
	private String firstName;
	private String lastName;
	private String email;
	private Boolean hasSensor;
}
