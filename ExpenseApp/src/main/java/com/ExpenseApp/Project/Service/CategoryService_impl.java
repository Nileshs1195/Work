package com.ExpenseApp.Project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ExpenseApp.Project.CustomExcpetion.RecordNotFoundException;
import com.ExpenseApp.Project.Dao.ICategoryDao;
import com.ExpenseApp.Project.pojo.Category;

@Service
public class CategoryService_impl implements ICategoryService
{
	@Autowired
	ICategoryDao categoryDao;
	@Override
	public String addCategory(Category category)
	{
		return categoryDao.addCategory(category);
	}
	
	@Override
	public List<Category> getCategoryList() 
	{	
		return categoryDao.getCategoryList();
	}
	
	@Override
	public Category getCategoryById(int cid)
	{
		Category catData=categoryDao.getCategoryById(cid);
		
		if(catData==null)
		{
			throw new RecordNotFoundException("Invalid Category Id");
		}
		return catData;
	}
}
