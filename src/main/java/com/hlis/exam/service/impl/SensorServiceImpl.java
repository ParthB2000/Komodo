package com.hlis.exam.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hlis.exam.dao.SensorDao;
import com.hlis.exam.entity.Boat;
import com.hlis.exam.entity.Sensor;
import com.hlis.exam.service.SensorService;

@Service
public class SensorServiceImpl extends BaseServiceImpl<Sensor, Integer> implements SensorService {

	@Autowired
	private SensorDao sensorDao;
	
	@PostConstruct
	public void setBaseDao()
	{
		super.baseDao = getDaoFactory().getSensorDao();
	}

	@Override
	public Sensor findByIdAndIsActiveAndIsDeleted(Integer id, Boolean isActive, Boolean isDeleted) {
		// TODO Auto-generated method stub
		return sensorDao.findByIdAndIsActiveAndIsDeleted(id, isActive, isDeleted);
	}

	@Override
	public List<Sensor> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted) {
		// TODO Auto-generated method stub
		return sensorDao.findByIsActiveAndIsDeleted(isActive, isDeleted);
	}

	@Override
	public List<Sensor> findByPressureGreaterThanAndIsActiveAndIsDeleted(Double pressure, Boolean isActive, Boolean isDeleted) {
		// TODO Auto-generated method stub
		return sensorDao.findByPressureGreaterThanAndIsActiveAndIsDeleted(pressure, isActive, isDeleted);
	}

	@Override
	public Sensor findByNameAndIsActiveAndIsDeleted(String name, Boolean isActive, Boolean isDeleted) {
		// TODO Auto-generated method stub
		return sensorDao.findByNameAndIsActiveAndIsDeleted(name, isActive, isDeleted);
	}

	@Override
	public Sensor findByBoatAndIsActiveAndIsDeleted(Boat boat, Boolean isActive, Boolean isDeleted) {
		// TODO Auto-generated method stub
		return sensorDao.findByBoatAndIsActiveAndIsDeleted(boat, isActive, isDeleted);
	}
}
