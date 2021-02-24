package com.cognizant.ormlearnpayroll.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearnpayroll.OrmLearnPayrollApplication;
import com.cognizant.ormlearnpayroll.model.Employee;
import com.cognizant.ormlearnpayroll.repository.EmployeeRepository;
/**
 * 
 * @author Danish
 *
 */
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	
	@Transactional
	public void saveEmployee(Employee employee)
	{
		LOGGER.info("Start");
		repository.save(employee);
		LOGGER.info("End");
	}
	
	@Transactional
	public Employee get(int id)
	{
		LOGGER.info("Start");
		return repository.findById(id).get();
	}
	
	@Transactional
	public List<Employee> getAllPermanentEmployee()
	{
		LOGGER.info("Start");
		return repository.getAllPermanentEmployee();
	}
	
	@Transactional
	public void deleteEmployee(int id)
	{
		LOGGER.info("Start");
		Employee e = repository.findById(id).get();
		//repository.deleteEmp(id);
		System.out.println(e);
			repository.delete(e);
		LOGGER.info("End");
	}
}
