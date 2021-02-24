package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Department;

import com.cognizant.service.DeparmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	DeparmentService service;

	/*
	 * Method -get http://localhost:9191/employees/allemp
	 */
	@GetMapping(value = "/alldept", produces = "application/json")
	public List<Department> getAllDepartments() {
		return service.getAllDepartments();
	}
}
