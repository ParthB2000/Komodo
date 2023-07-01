package com.hlis.exam.dao;

import org.springframework.stereotype.Repository;

import com.hlis.exam.entity.Otp;
import com.hlis.exam.entity.User;

@Repository
public interface OtpDao extends BaseDao<Otp, Integer> {

	Otp findByUserAndIsActiveAndIsDeleted(User user, Boolean isActive, Boolean isDeleted);
}
