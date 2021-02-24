package com.cognizant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.model.Employee;




public interface EmployeeService {

	 List<Employee> getAllEmployees();
}
