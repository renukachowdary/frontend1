package com.spring.dao;

import java.util.List;

import com.spring.model.*;
public interface UserDAO {

	
	public boolean saveUser(User user);
	public List<User> list();
	  public User getUserById(int user_id);
	  public void removeUserById(int user_id);
	  
	  public User get(String email);
		
	}