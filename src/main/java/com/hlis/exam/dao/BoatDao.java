package com.hlis.exam.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hlis.exam.entity.Boat;
import com.hlis.exam.entity.User;

@Repository
public interface BoatDao extends BaseDao<Boat, Integer> {

//	Boat findByUserAndIsActiveAndIsDeleted(User user, Boolean isActive, Boolean isDeleted);
	
//	List<Boat> findByUserAndIsActiveAndIsDeleted(User created_by ,Integer isActive, Integer isDeleted);
	
	List<Boat> findAllByCreatedByAndIsActiveAndIsDeleted(User user ,Boolean isActive, Boolean isDeleted);
	
	Boat findByIdAndIsActiveAndIsDeleted(Integer id, Boolean isActive, Boolean isDeleted);
	
	List<Boat> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted);
	
	List<Boat> findByHasSensorAndIsActiveAndIsDeleted(Boolean hasSensor, Boolean isActive, Boolean isDeleted);
	
	Boat findByCreatedByAndIsActiveAndIsDeleted(User user, Boolean isActive, Boolean isDeleted);
}
