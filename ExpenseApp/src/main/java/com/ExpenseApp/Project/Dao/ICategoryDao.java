package com.ExpenseApp.Project.Dao;

import java.util.List;

import com.ExpenseApp.Project.pojo.Category;

public interface ICategoryDao {
	
		
		public String addCategory(Category category);

		

		public List<Category> getCategoryList();



		public Category getCategoryById(int cid);
		

	}



