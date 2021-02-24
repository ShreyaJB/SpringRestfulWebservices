package com.cognizant.springlearn04.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn04.model.Country;
import com.cognizant.springlearn04.repositroy.CountryRepository;
import com.cognizant.springlearn04.service.exception.CountryNotFoundException;
/**
 * 
 * @author shiyam
 *
 */
@Service
public class CountryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
	
	@Autowired
	CountryRepository repository;
	/**
	 * addCountry used to add country to database
	 * @param country
	 */
	public void addCountry(Country country)
	{
		LOGGER.info("Start");
		repository.save(country);
		LOGGER.info("End");
	}
	
	/**
	 * findCountryByCode used to find country based on code
	 * @param code
	 * @return
	 * @throws CountryNotFoundException
	 */
	public Country findCountryByCode(String code) throws CountryNotFoundException
	{
		try {
		Country con =  repository.findByCodeContainingIgnoreCase(code);
		return con;
		}
		catch(Exception e)
		{
			throw e;
		}
//		Optional op =  repository.findById(code);
//		if(op.isPresent())
//			return (Country) op.get();
//		else
//			throw new CountryNotFoundException();
//		
	}

}
