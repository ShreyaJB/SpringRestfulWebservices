package com.cognizant.springlearn.service;

import java.util.List;

import com.cognizant.springlearn.country.Country;


public interface CountryService 
{
	Country getCountryIndia();
	List<Country> getAllCountries();
}