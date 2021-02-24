package com.cognizant.ormlearnpayroll;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends Exception {

}
