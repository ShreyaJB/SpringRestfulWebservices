package com.cognizant.springlearn04.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author Shiyam
 *
 */
@Entity
public class Country {
	
    @NotNull
    @Size(min=2, max=2, message="Country code should be 2 characters")
	@Id
	String code;
	@Column
	String name;	

	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
	public Country() {
		LOGGER.debug("Inside Country Class");
	}
	public String getName() {
		LOGGER.info("START");
		return name;
	}
	public void setName(String name) {
		LOGGER.info("START");
		this.name = name;
		 LOGGER.info("End");
	}
	public String getCode() {
		LOGGER.info("START");
		return code;
	}
	public void setCode(String code) {
		LOGGER.info("START");
		this.code = code;
		 LOGGER.info("End");
	}
	@Override
	public String toString() {
		return "Country [name=" + name + ", code=" + code + "]";
	}
	
	

}
