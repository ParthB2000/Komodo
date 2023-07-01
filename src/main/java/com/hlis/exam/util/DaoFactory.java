package com.hlis.exam.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hlis.exam.dao.BoatDao;
import com.hlis.exam.dao.OtpDao;
import com.hlis.exam.dao.SensorDao;
import com.hlis.exam.dao.UserDao;

import lombok.Getter;

@Component
@Getter
public class DaoFactory {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BoatDao boatDao;
	
	@Autowired
	private SensorDao sensorDao;
	
	@Autowired
	private OtpDao otpDao;
}
