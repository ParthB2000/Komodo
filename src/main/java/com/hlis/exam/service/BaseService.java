package com.hlis.exam.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, ID extends Serializable> {

public List<T> findAll();
	
	public T save(T t);
}
