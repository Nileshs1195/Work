              package com.ExpenseApp.Project.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ExpenseApp.Project.pojo.Category;

@Repository
@Transactional
public class CategoryDao_impl implements ICategoryDao
{
	@PersistenceContext
	EntityManager entityManager;
	
	public String addCategory(Category category)
	{
		 entityManager.persist(category);
		 return category.getCategoryName()+ " Category Added";
	}
	
	public List<Category> getCategoryList() {
	String jpql="select c from Category c  ";
	return entityManager.createQuery(jpql,Category.class).getResultList(); 
	}

	@Override
	public Category getCategoryById(int cid)
	{
		String jpql="Select c from Category c where c.categoryId=:id";
		//Category category=entityManager.createQuery(jpql,Category.class).setParameter("id", cid)getSingleResult();
		Category category=entityManager.createQuery(jpql,Category.class).setParameter("id", cid).getSingleResult();
		
		return category;
	}
}	
//String jpql="Select u from User u where u.email=:em and u.password=:pwd";
//User user=entitytManager.createQuery(jpql,User.class).setParameter("em", email).setParameter("pwd", password).getSingleResult();
//return user;
