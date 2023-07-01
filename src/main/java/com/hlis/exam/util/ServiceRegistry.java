package com.hlis.exam.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hlis.exam.service.BoatService;
import com.hlis.exam.service.OtpService;
import com.hlis.exam.service.SensorService;
import com.hlis.exam.service.UserService;
import com.hlis.exam.service.impl.EmailServiceImpl;

import lombok.Getter;

@Component
@Getter
public class ServiceRegistry {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
	@Autowired
	private BoatService boatService;
	
	@Autowired
	private SensorService sensorService;
	
	@Autowired
	private OtpService otpService;
}
