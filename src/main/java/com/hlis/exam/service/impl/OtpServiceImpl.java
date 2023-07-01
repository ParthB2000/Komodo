package com.hlis.exam.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hlis.exam.dao.OtpDao;
import com.hlis.exam.entity.Otp;
import com.hlis.exam.entity.User;
import com.hlis.exam.service.OtpService;

@Service
public class OtpServiceImpl extends BaseServiceImpl<Otp, Integer> implements OtpService {

	@Autowired
	private OtpDao otpDao;
	
	@PostConstruct
	public void setBaseDao()
	{
		super.baseDao = getDaoFactory().getOtpDao();
	}

	@Override
	public Otp findByUserAndIsActiveAndIsDeleted(User user, Boolean isActive, Boolean isDeleted) {
		// TODO Auto-generated method stub
		return otpDao.findByUserAndIsActiveAndIsDeleted(user, isActive, isDeleted);
	}
}
