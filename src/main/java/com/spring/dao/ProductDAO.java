package com.spring.dao;

import java.util.List;
import com.spring.model.Product;

public interface ProductDAO 
{
	public  boolean addProduct(Product product);
	public Product deleteProduct(int productId);
	public List<Product> retrieveProduct();
	public boolean updateProduct(Product product);

	public Product getItem(int id);
	public Product getProduct(int ProductId);
}