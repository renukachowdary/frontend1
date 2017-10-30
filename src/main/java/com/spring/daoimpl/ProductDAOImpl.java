package com.spring.daoimpl;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.ProductDAO;
import com.spring.model.Product;

@SuppressWarnings("deprecation")
@Repository("productDao")
public class ProductDAOImpl implements ProductDAO
{
	

    @Autowired
    SessionFactory sessionFactory;
    
    
	 public ProductDAOImpl(SessionFactory sessionFactory)
	  {
		  
		  this.sessionFactory=sessionFactory;
	  
	  }


    
    
    
    @Transactional
	
	public boolean addProduct(Product product) {
		 try
	        {
	            sessionFactory.getCurrentSession().saveOrUpdate(product);
	            return true;
	        }
	        catch(Exception e)
	        {
	        	System.out.println(e.getMessage());
	        return false;
	        }
	}
    
    
    
   

	    
    @Transactional

	public boolean updateProduct(Product product) 
    {
		
		 try
	        {
	        sessionFactory.getCurrentSession().saveOrUpdate(product);
	        return true;
	        }
	        catch(Exception e)
	        {
	        System.out.println("Exception Arised:"+e);
	        return false;
	        }
	    
	
	}
   @Transactional
	public Product getProductid(int productid) {
		// TODO Auto-generated method stub
		String hql = "from"+" Product"+" where id=" + productid;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) query.list();
		
		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}
		
	
		return null;
	
		
	}
    @Transactional
	public Product getItem(int id) {
		Product product=sessionFactory.getCurrentSession().get(Product.class, id);

		return product;
	}
	
	
    
    
@Transactional

	public Product deleteProduct(int productId) 
	{
		Product ProductToDelete = new Product();
		ProductToDelete.setProductId(productId);
			sessionFactory.getCurrentSession().delete(ProductToDelete);
			return ProductToDelete;
		
	}




@Transactional
public List<Product> retrieveProduct() {
	// TODO Auto-generated method stub

	 Session session=sessionFactory.openSession();
       @SuppressWarnings("rawtypes")
       Query query=session.createQuery("from Product");
       @SuppressWarnings("unchecked")
       List<Product> listProduct=query.list();
       session.close();
       return listProduct;
	
}





@Transactional
public Product getProduct(int ProductId) {
	String hql = "from"+" Product"+" where id=" + ProductId;
	@SuppressWarnings("rawtypes")
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	
	@SuppressWarnings("unchecked")
	List<Product> listProduct = (List<Product>) query.list();
	
	if (listProduct != null && !listProduct.isEmpty()) {
		return listProduct.get(0);
	}
	

	return null;
}





/*public Product getProductById(int id) {
	// TODO Auto-generated method stub
	String hql = "from"+" Product"+" where id=" + productid;
	@SuppressWarnings("rawtypes")
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	
	@SuppressWarnings("unchecked")
	List<Product> listProduct = (List<Product>) query.list();
	
	if (listProduct != null && !listProduct.isEmpty()) {
		return listProduct.get(0);
	}
	
	return null;*/
	

	
	
	

}