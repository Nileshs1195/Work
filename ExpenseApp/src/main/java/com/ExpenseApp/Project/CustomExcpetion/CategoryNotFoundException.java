package com.ExpenseApp.Project.CustomExcpetion;

public class CategoryNotFoundException extends RuntimeException
{
	public CategoryNotFoundException(String errorMessage)
	{
		super(errorMessage);
	}
	
}
