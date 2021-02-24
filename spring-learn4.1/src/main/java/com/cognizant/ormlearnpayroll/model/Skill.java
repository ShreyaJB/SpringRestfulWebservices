package com.cognizant.ormlearnpayroll.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Skill {
	
	@NotNull(message="Id should not be null")
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Name shoul not be blank")
	@Size(min = 1,max = 30)
	@Column
	private String name;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "skillList",fetch = FetchType.EAGER,cascade = CascadeType.ALL) 
	private Set<Employee> employeeList; 

	public Skill()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(Set<Employee> employeeList) {
		this.employeeList = employeeList;
	}

//	@Override
//	public String toString() {
//		return "Skill [id=" + id + ", name=" + name + "  + ]";
//	}
	
	
	
	
	

}
