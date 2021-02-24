package com.cognizant.ormlearnpayroll.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.ormlearnpayroll.EmployeeNotFoundException;
import com.cognizant.ormlearnpayroll.model.Employee;
import com.cognizant.ormlearnpayroll.service.EmployeeService;

@RestController
public class EmployeeController {
	
		@Autowired 
		EmployeeService service;
		
		@GetMapping("/emp/{id}")
		public Employee getEmployee(@PathVariable int id)
		{
			
		Employee temp = service.get(id);
		
		return temp;
		}
		
		@PutMapping("/updateemp")
		public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException
		{
			Employee temp = service.get(employee.getId());
			if(temp==null)
				throw new EmployeeNotFoundException();
			else
				service.saveEmployee(employee);
		}
		
		@DeleteMapping("/deleteemp/{id}")
		public void deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException
		{
			Employee temp = service.get(id);
			System.out.println(id);
			System.out.println(temp);
			if(temp==null)
				throw new EmployeeNotFoundException();
			else
				service.deleteEmployee(id);
		}
		
		

}
