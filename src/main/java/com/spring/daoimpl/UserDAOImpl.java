package com.spring.daoimpl;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.UserDAO;
import com.spring.model.User;


@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

		
		
		@Autowired	
		 SessionFactory sessionFactory;
		
		public UserDAOImpl(SessionFactory sessionFactory)
		{
		
		this.sessionFactory=sessionFactory;
			
		}

		public boolean saveUser(User user)
		{
			
			Session session=sessionFactory.openSession();
			session.saveOrUpdate(user);
			Transaction tx=session.beginTransaction();
			tx.commit();
			return true;
			
			
			
		}
}