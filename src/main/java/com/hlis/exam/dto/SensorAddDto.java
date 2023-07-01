package com.hlis.exam.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SensorAddDto {

	private Integer id;
	private String sensorName;
	private String humidity;
	private Double temperature;
	private String unit;
	private Double pressure;
}
