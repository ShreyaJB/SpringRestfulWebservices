package com.cognizant.springlearn04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 * 
 * @author shiyam
 *
 */
@SpringBootApplication
@ComponentScan("com.*")
public class SpringLearn04Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearn04Application.class, args);
	}

}
