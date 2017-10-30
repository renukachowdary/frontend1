package com.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.dao.CategoryDAO;
import com.spring.model.Category;






@Controller
public class CategoryController {
	
	@Autowired
	CategoryDAO categoryDAO;
	  
	 
	
	    @RequestMapping(value="AddCategory",method=RequestMethod.POST)
	 public String addCategory(@ModelAttribute("category")Category category,Model m)
	    {

	    	
	    	categoryDAO.addCategory(category);
	        
	        return "redirect:/category";
	    }
	    
	    
		@RequestMapping(value="category",method=RequestMethod.GET)
	    public String showCategory(@ModelAttribute("category")Category category,Model m)
	    {
	         
	        List<Category> listCategory=categoryDAO.retrieveCategory();
	        m.addAttribute("category", category);
	        m.addAttribute("categoryList",listCategory);
	        return "Category";
	    }
	    
		/* @RequestMapping(value="/updateCategory/{catId}",method=RequestMethod.GET)
		    public String updateCategory(@PathVariable("catId") int catId,Model m,RedirectAttributes attributes)
		     {
			 categoryDAO.updateCategory(catId);
				return "redirect:/category";
		    }*/
	    
		@RequestMapping(value="updateCategory/{catId}",method=RequestMethod.GET)
		    public String updateCategory(@PathVariable("catId") int catId,Model m,RedirectAttributes attributes)
		    {
		        Category category=categoryDAO.getCategory(catId);
		       // m.addAttribute(category);
		         attributes.addFlashAttribute("category",category);
		        List<Category> listCategory=categoryDAO.retrieveCategory();
		        m.addAttribute("categoryList",listCategory);
		        return "redirect:/category";
		    }
	    
	    @RequestMapping(value="/deleteCategory/{catId}",method=RequestMethod.GET)
	    public String deleteCategory(@PathVariable("catId")int catId,Model m,RedirectAttributes attributes)
	    {	
	    	categoryDAO.deleteCategory(catId);
			return "redirect:/category";
			
	    }

}