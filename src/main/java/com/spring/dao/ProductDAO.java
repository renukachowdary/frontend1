package com.spring.dao;

import java.util.List;
import com.spring.model.Product;

public interface ProductDAO 
{
	public  boolean addProduct(Product product);
	public Product deleteProduct(int product);
	public List<Product> retrieveProducts();
	public boolean updateProduct(Product product);
	public Product getProduct(int productId);
	public Product getItem(int productId);
}