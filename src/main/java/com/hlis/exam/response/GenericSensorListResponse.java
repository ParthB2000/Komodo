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
public class GenericSensorListResponse {

	private Integer id;
	private String name;
	private Double temperature;
	private String temperatureUnit;
	private Double pressure;
	private String humidity;
	private String  boatName;
	private String size;
	private Long capacity;
}
