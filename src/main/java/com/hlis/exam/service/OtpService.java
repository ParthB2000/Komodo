package com.hlis.exam.service;

import com.hlis.exam.entity.Otp;
import com.hlis.exam.entity.User;

public interface OtpService extends BaseService<Otp, Integer> {

	Otp save(Otp otp);
	
	Otp findByUserAndIsActiveAndIsDeleted(User user, Boolean isActive, Boolean isDeleted);
}
