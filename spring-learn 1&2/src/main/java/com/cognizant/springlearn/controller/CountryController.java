package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.SpringLearnApplication;
import com.cognizant.springlearn.country.Country;
import com.cognizant.springlearn.exception.CountryNotFoundException;
import com.fasterxml.jackson.databind.introspect.Annotated;

@RestController
public class CountryController {

	private static final Logger LOGGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	/**
	 * This method is used to display the India based on country.xml. Formatting
	 * Country using {@link ApplicationContext} class
	 * 
	 * we parse the Date to the {@link RequestMapping} {@link Annotated} is access
	 * the web page by port number and print the country according to the given
	 * format
	 * 
	 * send request based on http://localhost:8083/country
	 *
	 */
	@RequestMapping("/country")
	public Country getCountryIndia() {
		LOGGGER.info("Get Country India function START");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) appContext.getBean("in", Country.class);
		LOGGGER.debug("country {}", country);
		LOGGGER.info("Get Country India function END");
		((AbstractApplicationContext) appContext).close();
		return country;
	}

	/**
	 * This method is used to display the List of Countries based on country.xml.
	 * Formatting Country using {@link ApplicationContext} class
	 * 
	 * we parse the Date to the {@link GetMapping} {@link Annotated} is access the
	 * web page by port number and print the country according to the given format
	 * 
	 * send request based on http://localhost:8083/countries
	 *
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/countries")
	public List<Country> getAllCountries() {
		LOGGGER.info("Get All Country  function START");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countryList = appContext.getBean("countryList", ArrayList.class);
		LOGGGER.debug("Country List:{}", countryList);
		LOGGGER.info("Get All Country  function END");
		((AbstractApplicationContext) appContext).close();
		return countryList;
	}

	/**
	 * This method is used to display the Countries based on Code using country.xml.
	 * Formatting Country using {@link ApplicationContext} class
	 * 
	 * we parse the Date to the {@link GetMapping} {@link Annotated} is access the
	 * web page by port number and print the country according to the given format
	 * 
	 * send request based on http://localhost:8083/countries/{code}
	 *
	 */
	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable("code") String code) throws CountryNotFoundException {
		LOGGGER.info("Get Country by Code function START");
		@SuppressWarnings("resource")
		ApplicationContext appContext = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) appContext.getBean(code, Country.class);
		if (country != null) {
			return country;
		} else
			throw new CountryNotFoundException();
	}
}