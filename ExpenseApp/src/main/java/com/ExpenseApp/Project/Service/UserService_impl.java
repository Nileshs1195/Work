package com.ExpenseApp.Project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExpenseApp.Project.Dao.IUserDao;
import com.ExpenseApp.Project.pojo.User;

@Service
public class UserService_impl implements IUserService
{ 	
	@Autowired
	private IUserDao userDao;
	
	public String registerUser(User user)
	{
		return userDao.registerUser(user);
	}

	@Override
	public User loginUser(String email, String password)
	{
		return userDao.loginUser(email,password);
	}

	@Override
	public List<User> getUsersList() {
		
		return userDao.getUsersList();
	}
}
