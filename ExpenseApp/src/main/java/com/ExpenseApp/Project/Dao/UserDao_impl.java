package com.ExpenseApp.Project.Dao;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.ExpenseApp.Project.pojo.User;


@Repository
@Transactional
public class UserDao_impl implements IUserDao
{	
	@PersistenceContext
	private EntityManager entitytManager;
	
	public String registerUser(User user)
	{
		entitytManager.persist(user);
		return "Successfully Registered";	
	}
	
	@Override
	public User loginUser(String emailId, String passwords)
	{
//		String jpql="Select u from User u where u.email=:em and u.password=:pwd";
//		User user=entitytManager.createQuery(jpql,User.class).setParameter("em", email).setParameter("pwd", password).getSingleResult();
//		return user;
		
		CriteriaBuilder cb=entitytManager.getCriteriaBuilder();
		CriteriaQuery<User> cq=cb.createQuery(User.class);
		Root<User> user=cq.from(User.class);
		
		Predicate emailPrediacte=cb.equal(user.get("email"),emailId);
		Predicate passwordPredicare=cb.like(user.get("password"), passwords);
		
		cq.where(emailPrediacte,passwordPredicare);
		TypedQuery<User> query=entitytManager.createQuery(cq);
		//User userDetails=tq.getSingleResult();
		//return userDetails;
		return query.getSingleResult();
		
		
//		CriteriaBuilder cb=entitytManager.getCriteriaBuilder();
//		CriteriaQuery<User> cq=cb.createQuery(User.class);
//		Root<User> user=cq.from(User.class);
//		CriteriaQuery<User> select=cq.select(user);
//		TypedQuery<User> tq=entitytManager.createQuery(select);
//		User u=tq.getSingleResult();
//		return u;
	}
	
	
	
	public List<User> getUsersList()
	{
	CriteriaBuilder cb=entitytManager.getCriteriaBuilder();
	CriteriaQuery<User> cq=cb.createQuery(User.class);
	Root<User> user=cq.from(User.class);
	CriteriaQuery<User> select=cq.select(user);
	TypedQuery<User> t=entitytManager.createQuery(select);
	List<User> users=t.getResultList();
	return users;
	}	
}
