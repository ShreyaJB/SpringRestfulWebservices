package com.cognizant.ormlearnpayroll.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 
 * @author Danish
 *
 */
@Entity
public class Employee {

	@NotNull(message="Id should not be null")
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Name shoul not be blank")
	@Size(min = 1,max = 30)
	@Column
	private String name;
	@NotNull(message="should not be null")
	@Positive(message="salary should be greate than 0")
	@Column
	private double salary;
	@Column
	private boolean permanent;
	
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_dp_id")
	private Department department;

	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "employee_skill", 
	joinColumns = @JoinColumn(name = "es_em_id"),
	inverseJoinColumns = @JoinColumn(name = "es_sk_id")) 
	private Set<Skill> skillList;

	public Employee() {

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	

	public Set<Skill> getSkillList() {
		return skillList;
	}

	public void setSkillList(Set<Skill> skillList) {
		this.skillList = skillList;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
				+ ", dateOfBirth=" + dateOfBirth + ", skillList=" + skillList + "]";
	}

	

}
