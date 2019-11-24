package com.ExpenseApp.Project.Service;

import java.util.List;

import com.ExpenseApp.Project.pojo.Category;

public interface ICategoryService
{
	
	public String addCategory(Category category);

	public List<Category> getCategoryList();

	public Category getCategoryById(int cid);


}
