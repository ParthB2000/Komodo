package com.hlis.exam.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hlis.exam.dao.BaseDao;
import com.hlis.exam.util.DaoFactory;

import lombok.Getter;

@Getter
public class BaseServiceImpl<T, ID extends Serializable> {

	@Autowired
	private DaoFactory daoFactory;
	
	@Autowired
	protected BaseDao<T, ID> baseDao;
	
	public List<T> findAll()
	{
		return baseDao.findAll();
	}
	
	public T save(T t)
	{
		return baseDao.save(t);
	}
	
}
