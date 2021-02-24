package com.cognizant.springlearn.country;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {

	private String code;
	private String name;
	private static final Logger LOGGGER = LoggerFactory.getLogger(Country.class);
	public Country() {
		super();
		LOGGGER.debug("Inside Country Constructor");
	}
	public String getCode() {
		LOGGGER.debug("Inside code getter");
		return code;
	}
	public void setCode(String code) {
		LOGGGER.debug("Inside code setter");
		this.code = code;
	}
	public String getName() {
		LOGGGER.debug("Inside name getter");
		return name;
	}
	public void setName(String name) {
		LOGGGER.debug("Inside name setter");
		this.name = name;
	}
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
	

}
