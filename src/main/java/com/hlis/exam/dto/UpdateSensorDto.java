package com.hlis.exam.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdateSensorDto {

	private Integer sensor_id;
	private Double temperature;
	private String temperature_unit;
	private Double pressure;
	private String humidity;
}
