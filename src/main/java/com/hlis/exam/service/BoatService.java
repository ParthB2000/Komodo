package com.hlis.exam.service;

import java.util.List;

import com.hlis.exam.entity.Boat;
import com.hlis.exam.entity.User;

public interface BoatService extends BaseService<Boat, Integer> {

	Boat save(Boat boat);
	
	List<Boat> findAllByCreatedByAndIsActiveAndIsDeleted(User user ,Boolean isActive, Boolean isDeleted);
	
	Boat findByIdAndIsActiveAndIsDeleted(Integer id, Boolean isActive, Boolean isDeleted);
	
	List<Boat> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted);
	
	List<Boat> findByHasSensorAndIsActiveAndIsDeleted(Boolean hasSensor, Boolean isActive, Boolean isDeleted);
	
	Boat findByCreatedByAndIsActiveAndIsDeleted(User user, Boolean isActive, Boolean isDeleted);
}
