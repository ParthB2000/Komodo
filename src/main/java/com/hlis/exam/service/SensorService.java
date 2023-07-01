package com.hlis.exam.service;

import java.util.List;

import com.hlis.exam.entity.Boat;
import com.hlis.exam.entity.Sensor;

public interface SensorService extends BaseService<Sensor, Integer> {

	Sensor save(Sensor sensor);
	
	Sensor findByIdAndIsActiveAndIsDeleted(Integer id, Boolean isActive, Boolean isDeleted);
	
	List<Sensor> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted);
	
	List<Sensor> findByPressureGreaterThanAndIsActiveAndIsDeleted(Double pressure, Boolean isActive, Boolean isDeleted);
	
	Sensor findByNameAndIsActiveAndIsDeleted(String name, Boolean isActive, Boolean isDeleted);
	
	Sensor findByBoatAndIsActiveAndIsDeleted(Boat boat, Boolean isActive, Boolean isDeleted);
}
