package com.hlis.exam.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tbl_sensor")
public class Sensor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String tempUnit;
	
	private Double temperature;
	
	private String humidity;
	
	private Double pressure;
	
	private String name;
	
	private Boolean isDeleted=false;
	
	private Boolean isActive=true;
	
	@Column(columnDefinition = "Timestamp default CURRENT_TIMESTAMP")
	private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
	
	@Column(columnDefinition = "Timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
	
	@OneToOne
	private Boat boat;
}
