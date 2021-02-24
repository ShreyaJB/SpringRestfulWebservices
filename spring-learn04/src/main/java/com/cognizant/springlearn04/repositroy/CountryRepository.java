package com.cognizant.springlearn04.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn04.model.Country;
/**
 * 
 * @author shiyam
 *
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
	
	public Country findByCodeContainingIgnoreCase(String code);

}
