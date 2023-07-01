package com.hlis.exam.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hlis.exam.dao.BoatDao;
import com.hlis.exam.entity.Boat;
import com.hlis.exam.entity.User;
import com.hlis.exam.service.BoatService;

@Service
public class BoatServiceImpl extends BaseServiceImpl<Boat, Integer> implements BoatService {

	@Autowired
	private BoatDao boatDao;
	
	@PostConstruct
	public void setBaseDao()
	{
		super.baseDao = getDaoFactory().getBoatDao();
	}

	@Override
	public List<Boat> findAllByCreatedByAndIsActiveAndIsDeleted(User user, Boolean isActive, Boolean isDeleted) {
		// TODO Auto-generated method stub
		return boatDao.findAllByCreatedByAndIsActiveAndIsDeleted(user, isActive, isDeleted);
	}

	@Override
	public Boat findByIdAndIsActiveAndIsDeleted(Integer id, Boolean isActive, Boolean isDeleted) {
		// TODO Auto-generated method stub
		return boatDao.findByIdAndIsActiveAndIsDeleted(id, isActive, isDeleted);
	}

	@Override
	public List<Boat> findByIsActiveAndIsDeleted(Boolean isActive, Boolean isDeleted) {
		// TODO Auto-generated method stub
		return boatDao.findByIsActiveAndIsDeleted(isActive, isDeleted);
	}

	@Override
	public List<Boat> findByHasSensorAndIsActiveAndIsDeleted(Boolean hasSensor, Boolean isActive, Boolean isDeleted) {
		// TODO Auto-generated method stub
		return boatDao.findByHasSensorAndIsActiveAndIsDeleted(hasSensor, isActive, isDeleted);
	}

	@Override
	public Boat findByCreatedByAndIsActiveAndIsDeleted(User user, Boolean isActive, Boolean isDeleted) {
		// TODO Auto-generated method stub
		return boatDao.findByCreatedByAndIsActiveAndIsDeleted(user, isActive, isDeleted);
	}
}
