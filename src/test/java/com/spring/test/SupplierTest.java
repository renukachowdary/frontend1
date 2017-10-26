package com.spring.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.dao.SupplierDAO;
import com.spring.model.Supplier;

@Ignore
public class SupplierTest {
	  private static final int supId = 0;
	static SupplierDAO supplierDAO;
	     
	    @BeforeClass
	    public static void initialize()
	    {
	        @SuppressWarnings("resource")
			AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
	        configApplnContext.scan("com.spring");
	        configApplnContext.refresh();
	         
	        //SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("DataBaseConfig.class");
	         
	        supplierDAO=(SupplierDAO)configApplnContext.getBean("supplierDAO");
	    }
	    
	    @Test
	    public void addSupplierTest()
	    {
	        Supplier supplier=new Supplier();
	        supplier.setSupId(653);
	        supplier.setSupName("city jewelery");
	        supplier.setSupDesc("all kinds of jewelery are available ");
	        assertTrue(supplierDAO.addSupplier(supplier));
	    }
	    @Ignore
	    @Test
	    public void updateSupplierTest()
		{
			Supplier supplier=new Supplier();
			supplier.setSupId(1001);
			supplier.setSupName("rings");
			supplier.setSupDesc("The Indian climatic life.");
			
			assertTrue(supplierDAO.updateSupplier(supId));
		}
	    
	    @Ignore
		@Test
		public void deleteSupplierTest()
		{
			Supplier Supplier=new Supplier();
			Supplier.setSupId(1002);
			int supId = 0;
			assertTrue(supplierDAO.deleteSupplier(supId));
		}
		@Ignore
		@Test
		public void retrieveSupplierTest()
		{
			List<Supplier> listSupplier=supplierDAO.retrieveSupplier();
			assertNotNull("Problem in Retriving ",listSupplier);
			this.show(listSupplier);
		}
		
		public void show(List<Supplier> listSupplier)
		{
			for(Supplier Supplier:listSupplier)
			{
				System.out.println("Supplier ID:"+Supplier.getSupId());
				System.out.println("Supplier Name:"+Supplier.getSupName());
			}
		}
		
		@Ignore
		@Test
		public void getSupplierTest()
		{
			Supplier Supplier=supplierDAO.getSupplier(1001);
			assertNotNull("Problem in Getting:",Supplier);
			System.out.println("Supplier ID:"+Supplier.getSupId());
			System.out.println("Supplier Name:"+Supplier.getSupName());
			System.out.println("Supplier Description  = "+Supplier.getSupDesc());
		}

}
