package com.spring.test;
import static org.junit.Assert.*;




import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.spring.dao.ProductDAO;
import com.spring.model.Product;


public class ProductTest {
	private static ProductDAO productDAO;
	
	@BeforeClass
	public static void initialize()
	{
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext configAppinContext=new AnnotationConfigApplicationContext();
		configAppinContext.scan("com.spring");
		configAppinContext.refresh();
		//SessionFactory sessionFactory=(Conf.getBean(requiredType, args))
		productDAO=(ProductDAO)configAppinContext.getBean("productDAO");

	}
	
	@Test
	public void addProductTest()
	{
		 Product product= new Product();
		 product.setProductId(1002);
		 product.setProductName("sa");
		 product.setProductDesc("this");
		 product.setPrice(2000);
		 product.setStock(25);
		 product.setCatId(10);
		 product.setSupId(1000);
		 assertTrue("problem in insertion",productDAO.addProduct(product));
	}

}