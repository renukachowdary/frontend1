package com.spring.daoimpl;

import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

		public List<User> list() {
			// TODO Auto-generated method stub
			return null;
		}

		public User getUserById(int user_id) {
			// TODO Auto-generated method stub
			return null;
		}

		public void removeUserById(int user_id) {
			// TODO Auto-generated method stub
			
		}
@Transactional
		public User get(String email) {
	@SuppressWarnings("deprecation")
	Criteria c = sessionFactory.getCurrentSession().createCriteria(User.class);
	c.add(Restrictions.eq("email", email));

	@SuppressWarnings("unchecked")
	List<User> listUser = (List<User>) c.list();

	if (listUser != null && !listUser.isEmpty()) {
		return listUser.get(0);
	} else {
		return null;
	}
		}
}