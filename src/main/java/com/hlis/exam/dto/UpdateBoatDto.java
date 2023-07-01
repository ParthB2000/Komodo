package com.hlis.exam.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdateBoatDto {

	private Integer boatId;
	private String boatName;
	private Long boatCapacity;
	private String boatSize;
}
