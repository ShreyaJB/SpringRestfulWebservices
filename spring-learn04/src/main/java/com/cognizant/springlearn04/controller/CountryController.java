package com.cognizant.springlearn04.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn04.model.Country;
import com.cognizant.springlearn04.service.CountryService;
import com.cognizant.springlearn04.service.exception.CountryNotFoundException;

/**
 * 
 * @author shiyam
 *
 */
@RestController
public class CountryController {

	@Autowired
	private CountryService service;
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

	/**
	 * getCountryIndia() methods return object of country which has data ofIndia
	 * 
	 * @return
	 */
	@PostMapping("/add")
	public Country addCountry(@RequestBody @Valid Country country) {
		LOGGER.info("START");

//		// Create validator factory
//		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//		Validator validator = factory.getValidator();
//
//		// Validation is done against the annotations defined in country bean
//		Set<ConstraintViolation<Country>> violations = validator.validate(country);
//		List<String> errors = new ArrayList<String>();
//
//		// Accumulate all errors in an ArrayList of type String
//		for (ConstraintViolation<Country> violation : violations) {
//			errors.add(violation.getMessage());
//		}
//
//		// Throw exception so that the user of this web service receives appropriate
//		// error message
//		if (violations.size() > 0) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());
//		} 
//		else {

			service.addCountry(country);
			LOGGER.debug("Country {}", country);

			LOGGER.info("End");
			return country;
		//}
	}

//	/**
//	 * getAllCountries() returns the list of all countries
//	 * @return
//	 */
//	@RequestMapping(value = "/countries", method = RequestMethod.GET)
//	public static List<Country> getAllCountries() {
//		LOGGER.info("START");
//
//		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
//		ArrayList<Country> countryList = context.getBean("countryList", ArrayList.class);
//
//		LOGGER.debug("Country {}", countryList);
//
//		LOGGER.info("End");
//
//		return countryList;
//	}

	/**
	 * getCountry() get country based on code
	 * 
	 * @param code
	 * @return
	 * @throws CountryNotFoundException
	 */
	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable("code") String code) throws CountryNotFoundException {
		LOGGER.info("START");

		Country country = service.findCountryByCode(code);
		if (country != null)
			return country;
		else
			throw new CountryNotFoundException();

	}

}
