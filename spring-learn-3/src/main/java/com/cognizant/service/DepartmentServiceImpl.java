package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.DepartmentRepository;
import com.cognizant.model.Department;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentServiceImpl implements DeparmentService
{
	@Autowired
	DepartmentRepository respository;

	@Override
	public List<Department> getAllDepartments() {
		log.info("started");
		log.debug("Department are {}:"+respository.findAll());
		return respository.findAll();
	}

	
}
