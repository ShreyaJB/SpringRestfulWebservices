package com.cognizant.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee
{

	@Id
	private int id;
	@NotBlank(message = "Name can't be blank")
	@Pattern(regexp = "[A-Z]{1}[A-Za-z\\s]{3,}" ,message = "Name should start with a Capital letter followed by only chars")
	private String name;
	
}
