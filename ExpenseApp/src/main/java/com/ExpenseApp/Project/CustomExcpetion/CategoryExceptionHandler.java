package com.ExpenseApp.Project.CustomExcpetion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CategoryExceptionHandler 
{
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<Object> catException(CategoryNotFoundException catException)
	{
		return new  ResponseEntity<Object> ("Category Not Found, not available in stock..Try After Some Time",HttpStatus.NOT_FOUND);
	}
	
}
