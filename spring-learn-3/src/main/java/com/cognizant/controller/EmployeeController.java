package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Employee;
import com.cognizant.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	/*
	 * Method -get
	 * http://localhost:9191/employees/allemp
	 */
	@GetMapping(value = "/allemp",produces = "application/json")
	public List<Employee> getAllEmployees(){
		return service.getAllEmployees();
	}
	
	
}

//	
//	
//	
//	/*
//	 * Method -get
//	 * http://localhost:9191/employees/1001
//	 */
//	@GetMapping(value = "/{id}",produces = "application/json")
//	public Employee getEmployee(@PathVariable("id") int id) throws EmployeeException{
//		Employee emp=null;
//		
//			emp=service.getEmployeeById(id);
//		
//		return emp;
//	}
//	
//	
//
//	/*
//	 * Method -post
//	 * http://localhost:9191/employees/add
//	 body => raw => json then type complete object information
//	 {
//        "id": 2001,
//        "name": "Abcd",
//        "gender": "male",
//        "age": 28,
//        "salary": 45000.0,
//        "city": "Bangalore",
//        "dateOfJoining": "2000-12-12"
//    }
//	 */
//	@PostMapping("/add")
//	public String addEmployee(@Valid @RequestBody Employee emp) throws EmployeeException {
//		return service.addEmployee(emp);
//	}
//	
//	/*
//	 * Method -Get
//	 * http://localhost:9191/employees//addrequest?id=5656&name=anu&gender=female&age=22&salary=33333&city=pune&dateOfJoining=2020-05-01
//	 */
//	
//	
//	@GetMapping("/addrequest")
//	public String addEmployeeWithRequestParam(@RequestParam("id")int id,
//			@RequestParam("name")String name,
//			@RequestParam("gender")String gender,
//			@RequestParam("age")int age,
//			@RequestParam("salary")double salary,
//			@RequestParam("city")String city,
//			@RequestParam("dateOfJoining")String dateOfJoining
//			) throws EmployeeException {
//		LocalDate doj=LocalDate.parse(dateOfJoining);
//		Employee emp=new Employee(id, name, gender, age, salary, city, doj);
//		return service.addEmployee(emp);
//	}
//	
//	/*
//	 * Method -put
//	 * http://localhost:9191/employees/update
//	 body => raw => json then type complete object information
//	 {
//        "id": 203,
//        "name": "Priya",
//        "gender": "female",
//        "age": 28,
//        "salary": 45000.0,
//        "city": "Bangalore",
//        "dateOfJoining": "2010-12-12"
//    }
//	 */
//	@PutMapping("/update")
//	public String updateEmployee(@Valid @RequestBody Employee emp) throws EmployeeException {
//		return service.updateEmployee(emp);
//	}
//	
//	/*
//	 * Method -delete
//	 * http://localhost:9191/employees/delete/2001
//	 */
//	@DeleteMapping(value = "/delete/{id}")
//	public String deleteEmployee(@PathVariable("id") int id) throws EmployeeException{
//		
//			return service.deleteEmployeeById(id);
//		
//	}
//	
//	
//	/*
//	 * Method -get
//	 * http://localhost:9191/employees/salary/50000/80000
//	 */
//	@GetMapping(value = "/salary/{lower}/{upper}",produces = "application/json")
//	public List<Employee> getEmployee(@PathVariable("lower") double lower,
//			@PathVariable("upper") double upper){
//		return service.getEmployeeBasedonSalary(lower, upper);
//	}
	
	

