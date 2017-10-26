package com.spring.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.CategoryDAO;
import com.spring.model.Category;

@SuppressWarnings("deprecation")
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean addCategory(Category category) {
		
		 try
	        {
			 
	        Session session=sessionFactory.getCurrentSession();
	        session.saveOrUpdate(category);
	        
	        return true;
	        }
	        catch(Exception e)
	        {
	        	System.out.println(e.getMessage());
	        return false;
	        }
	
	}

	@Transactional
	public List<Category> retrieveCategory() {
		// TODO Auto-generated method stub
		 Session session=sessionFactory.openSession();
	        @SuppressWarnings("rawtypes")
			Query query=session.createQuery("from Category");
	        @SuppressWarnings("unchecked")
			List<Category> listCategory=query.list();
	        session.close();
	        return listCategory;
		
	}
	@Transactional
	public Category deleteCategory(int category) {
		// TODO Auto-generated method stub
		Category categoryToDelete=new Category();
		 categoryToDelete.setCatId(category);
		 sessionFactory.getCurrentSession().delete(categoryToDelete);
		 return categoryToDelete;
	}
	@Transactional

	public Category getCategory(int catId) {
		// TODO Auto-generated method stub
		String hql = "from"+" Category"+" where id=" + catId;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();
		
		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}
		
		return null;
	
	}
	@Transactional
	public boolean updateCategory(Category category) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
		
	}

	public Category deleteCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}
}

	