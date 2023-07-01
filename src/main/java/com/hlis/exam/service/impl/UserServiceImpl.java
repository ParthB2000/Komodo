package com.hlis.exam.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hlis.exam.dao.UserDao;
import com.hlis.exam.entity.User;
import com.hlis.exam.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {

	@Autowired
	private UserDao userDao;
	
	@PostConstruct
	public void setBaseDao()
	{
		super.baseDao = getDaoFactory().getUserDao();
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.findByEmail(email);
	}

	@Override
	public User findByIdAndIsActiveAndIsDeleted(Integer id, Boolean isActive, Boolean isDeleted) {
		// TODO Auto-generated method stub
		return userDao.findByIdAndIsActiveAndIsDeleted(id, isActive, isDeleted);
	}

	@Override
	public User findByEmailAndIsVerifiedAndIsActiveAndIsDeleted(String email, Boolean isVerified, Boolean isActive,
			Boolean isDeleted) {
		// TODO Auto-generated method stub
		return userDao.findByEmailAndIsVerifiedAndIsActiveAndIsDeleted(email, isVerified, isActive, isDeleted);
	}

	@Override
	public List<User> findByIsBlockedAndRoleAndIsActiveAndIsDeleted(Boolean isBlocked, String role ,Boolean isActive, Boolean isDeleted) {
		// TODO Auto-generated method stub
		return userDao.findByIsBlockedAndRoleAndIsActiveAndIsDeleted(isBlocked, role ,isActive, isDeleted);
	}
	
	@Override
	public List<User> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted) {
		// TODO Auto-generated method stub
		return userDao.findByIsActiveAndIsDeleted(isActive, isDeleted);
	}

	@Override
	public User findByEmailAndIsBlockedAndIsVerifiedAndIsActiveAndIsDeleted(String email, Boolean isBlocked,
			Boolean isVerified, Boolean isActive, Boolean isDeleted) {
		// TODO Auto-generated method stub
		return userDao.findByEmailAndIsBlockedAndIsVerifiedAndIsActiveAndIsDeleted(email, isBlocked, isVerified, isActive, isDeleted);
	}

	@Override
	public User findByEmailAndPasswordAndRoleAndIsActiveAndIsDeleted(String email, String password, String role,
			Boolean isActive, Boolean isDeleted) {
		// TODO Auto-generated method stub
		return userDao.findByEmailAndPasswordAndRoleAndIsActiveAndIsDeleted(email, password, role, isActive, isDeleted);
	}

	@Override
	public List<User> findAllByIsBlockedAndIsVerifiedAndIsActiveAndIsDeleted(Boolean isBlocked, Boolean isVerified,
			Boolean isActive, Boolean isDeleted) {
		// TODO Auto-generated method stub
		return userDao.findAllByIsBlockedAndIsVerifiedAndIsActiveAndIsDeleted(isBlocked, isVerified, isActive, isDeleted);
	}

	@Override
	public User findByTokenAndRoleAndIsBlockedAndIsActiveAndIsDeleted(String token, String role, Boolean isBlocked, Boolean isActive,
			Boolean isDeleted) {
		// TODO Auto-generated method stub
		return userDao.findByTokenAndRoleAndIsBlockedAndIsActiveAndIsDeleted(token, role, isBlocked, isActive, isDeleted);
	}

	@Override
	public User findByIdAndRoleAndIsBlockedAndIsActiveAndIsDeleted(Integer id, String role, Boolean isBlocked,
			Boolean isActive, Boolean isDeleted) {
		// TODO Auto-generated method stub
		return userDao.findByIdAndRoleAndIsBlockedAndIsActiveAndIsDeleted(id, role, isBlocked, isActive, isDeleted);
	}
}
