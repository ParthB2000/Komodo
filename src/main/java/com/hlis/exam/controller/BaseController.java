package com.hlis.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.hlis.exam.util.ServiceRegistry;

import lombok.Getter;

@Getter
public class BaseController {

	@Autowired
	private ServiceRegistry serviceRegistry;
	
}
