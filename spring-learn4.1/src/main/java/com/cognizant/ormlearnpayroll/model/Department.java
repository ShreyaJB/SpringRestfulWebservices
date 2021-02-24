package com.cognizant.ormlearnpayroll.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * 
 * @author Danish
 *
 */
@Entity
public class Department {
	
	@NotNull(message="Id should not be null")
	@Id
	@Column
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@NotBlank(message = "Name shoul not be blank")
	@Size(min = 1,max = 30)
	@Column
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "department",cascade =CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Employee> employee;
	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public Department()
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

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name  + "]";
	}
	
	
	
}
