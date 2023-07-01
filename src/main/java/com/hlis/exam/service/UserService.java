package com.hlis.exam.service;

import java.util.List;

import com.hlis.exam.entity.User;

public interface UserService extends BaseService<User, Integer> {

	User save(User user);
	
	User findByEmail(String email);
	
	User findByEmailAndIsVerifiedAndIsActiveAndIsDeleted(String email, Boolean isVerified, Boolean isActive, Boolean isDeleted);
	
	User findByEmailAndIsBlockedAndIsVerifiedAndIsActiveAndIsDeleted(String email,Boolean isBlocked, Boolean isVerified, Boolean isActive, Boolean isDeleted);
	
	User findByIdAndIsActiveAndIsDeleted(Integer id, Boolean isActive, Boolean isDeleted);
	
	List<User> findByIsBlockedAndRoleAndIsActiveAndIsDeleted(Boolean isBlocked, String role ,Boolean isActive, Boolean isDeleted);
	
	List<User> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted);
	
	User findByEmailAndPasswordAndRoleAndIsActiveAndIsDeleted(String email, String password, String role, Boolean isActive, Boolean isDeleted);
	
	List<User>  findAllByIsBlockedAndIsVerifiedAndIsActiveAndIsDeleted(Boolean isBlocked, Boolean isVerified, Boolean isActive, Boolean isDeleted);
	
	User findByTokenAndRoleAndIsBlockedAndIsActiveAndIsDeleted(String token, String role, Boolean isBlocked, Boolean isActive, Boolean isDeleted);
	
	User findByIdAndRoleAndIsBlockedAndIsActiveAndIsDeleted(Integer id, String role, Boolean isBlocked, Boolean isActive, Boolean isDeleted);
}
