package com.spring.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.spring.dao.CategoryDAO;
import com.spring.model.Category;

import static org.junit.Assert.assertTrue;

@Ignore

public class CategoryTest 
{
    static CategoryDAO categoryDAO;
     
    @BeforeClass
    public static void initialize()
    {
        @SuppressWarnings("resource")
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
        configApplnContext.scan("com.spring");
        configApplnContext.refresh();
         
        //SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("DataBaseConfig.class");
         
        categoryDAO=(CategoryDAO)configApplnContext.getBean("categoryDAO");
    }
    
    @Test
    public void addCategoryTest()
    {
        Category category=new Category();
        category.setCatId(101);
        category.setCatName("rings");
        category.setCatDesc(" worn as an ornamental piece of jewellery around the finger ");
        assertTrue(categoryDAO.addCategory(category));
    }
    @Ignore
    @Test
    public void updateCategoryTest()
	{
		Category category=new Category();
		category.setCatId(103);
		category.setCatName("rings");
		category.setCatDesc("The Indian climatic life.");
		
		assertTrue(categoryDAO.updateCategory(category));
	}
}
    