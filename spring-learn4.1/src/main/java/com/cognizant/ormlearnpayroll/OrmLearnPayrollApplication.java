package com.cognizant.ormlearnpayroll;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.cognizant.ormlearnpayroll.model.Department;
import com.cognizant.ormlearnpayroll.model.Employee;
import com.cognizant.ormlearnpayroll.model.Skill;
import com.cognizant.ormlearnpayroll.service.DepartmentService;
import com.cognizant.ormlearnpayroll.service.EmployeeService;
import com.cognizant.ormlearnpayroll.service.SkillService;

/**
 * 
 * @author Danish
 *
 */

@SpringBootApplication
@ComponentScan("com.*")
public class OrmLearnPayrollApplication {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnPayrollApplication.class); 
	
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(OrmLearnPayrollApplication.class, args);
	}
	


}
