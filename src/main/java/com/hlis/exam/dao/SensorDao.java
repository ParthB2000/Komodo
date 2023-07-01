package com.hlis.exam.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hlis.exam.entity.Boat;
import com.hlis.exam.entity.Sensor;

@Repository
public interface SensorDao extends BaseDao<Sensor, Integer> {

	Sensor findByIdAndIsActiveAndIsDeleted(Integer id, Boolean isActive, Boolean isDeleted);
	
	List<Sensor> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted);
	
	List<Sensor> findByPressureGreaterThanAndIsActiveAndIsDeleted(Double pressure, Boolean isActive, Boolean isDeleted);
	
	Sensor findByNameAndIsActiveAndIsDeleted(String name, Boolean isActive, Boolean isDeleted);
	
	Sensor findByBoatAndIsActiveAndIsDeleted(Boat boat, Boolean isActive, Boolean isDeleted);
}
