package com.cognizant.ormlearnpayroll.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearnpayroll.model.Department;
import com.cognizant.ormlearnpayroll.repository.DepartmentRepository;
/**
 * 
 * @author Danish
 *
 */
@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);
	
	@Transactional
	public Department get(int id)
	{
		LOGGER.info("Start");
		return repository.findById(id).get();
	}
	
	@Transactional
	public void saveDepartment(Department department)
	{
		LOGGER.info("Start");
		repository.save(department);
		LOGGER.info("End");
	}
}
