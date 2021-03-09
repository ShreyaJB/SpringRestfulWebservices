package com.cognizant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.country.Country;


@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		LOGGGER.info("Main Start");

		LOGGGER.info("Display Date Start in main");
		displayDate();
		LOGGGER.info("Display Date End in main");

		LOGGGER.info("Display Country Start in main");
		displayCountry();
		LOGGGER.info("Display Country End in main");

		LOGGGER.info("Display Countries Start in main");
		displayCountries();
		LOGGGER.info("Display Countries End in main");
		LOGGGER.info("Main End");
	}

	/**
	 * This method is used to display the date based on date-format.xml. Formatting
	 * Date using {@link SimpleDateFormat} class
	 * 
	 * we parse the Date to the {@link SimpleDateFormat}class and print the date
	 * according to the given format
	 *
	 */
	public static void displayDate() {
		LOGGGER.info("START");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = appContext.getBean("dateFormat", SimpleDateFormat.class);
		try {
			Date date = format.parse("31/12/2018");
			LOGGGER.debug("Date {}", date.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		((AbstractApplicationContext) appContext).close();
		LOGGGER.info("END");
	}

	/**
	 * This method is used to display the countries based on country.xml. Formatting
	 * Country using {@link ApplicationContext} class
	 * 
	 * we parse the Date to the {@link ApplicationContext}class and print the country
	 * according to the given format
	 *
	 */
	public static void displayCountry() {
		LOGGGER.info("Function START the Display Country");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) appContext.getBean("country", Country.class);
		Country anotherCountry = (Country) appContext.getBean("country", Country.class);
		System.out.println(country.hashCode());
		System.out.println(anotherCountry.hashCode());
		LOGGGER.debug("Country:{}", country.toString());
		LOGGGER.debug("Country:{}", anotherCountry.toString());
		((AbstractApplicationContext) appContext).close();
		LOGGGER.info("Function END the Display Country");
	}


	/**
	 * This method is used to display the List of countries based on country.xml. Formatting
	 * Country using {@link ApplicationContext} class
	 * 
	 * we parse the Date to the {@link ApplicationContext}class and print the country
	 * according to the given format
	 *
	 */
	public static void displayCountries() {
		LOGGGER.info("START the Display List of Country");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("country.xml");
		@SuppressWarnings("unchecked")
		List<Country> countryList = appContext.getBean("countryList", ArrayList.class);
		LOGGGER.debug("Country List:{}", countryList);
		((AbstractApplicationContext) appContext).close();
		LOGGGER.info("END of the Display List of Country");
	}
}
