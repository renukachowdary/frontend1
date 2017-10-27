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
import com.spring.dao.SupplierDAO;
import com.spring.model.Category;
import com.spring.model.Supplier;


@Controller
public class SupplierController 
{	
	
	
	@Autowired
	SupplierDAO supplierDAO;
	  
	 
	
	    @RequestMapping(value="AddSupplier",method=RequestMethod.POST)
	 public String addSupplier(@ModelAttribute("supplier")Supplier supplier,Model m)
	    {
	        supplierDAO.addSupplier(supplier);
	        
	        return "redirect:/supplier";
	    }
	    
	    
		@RequestMapping(value="supplier",method=RequestMethod.GET)
	    public String showSupplier(@ModelAttribute("supplier")Supplier supplier,Model m)
	    {
	         
	        List<Supplier> listSupplier=supplierDAO.retrieveSupplier();
	        m.addAttribute("supplier", supplier);
	        m.addAttribute("supplierList",listSupplier);
	        return "Supplier";
	    }
	    
		
		@RequestMapping(value="updateSupplier/{supId}",method=RequestMethod.GET)
		    public String updateSupplier(@PathVariable("supId") int supId,Model m,RedirectAttributes attributes)
		    {
		        Supplier supplier=supplierDAO.getSupplier(supId);
		       // m.addAttribute(supplier);
		         attributes.addFlashAttribute("supplier",supplier);
		        List<Supplier> listSupplier=supplierDAO.retrieveSupplier();
		        m.addAttribute("supplierList",listSupplier);
		        return "redirect:/supplier";
		    }
	    
	    @RequestMapping(value="/deleteSupplier/{supId}",method=RequestMethod.GET)
	    public String deleteSupplier(@PathVariable("supId")int supId,Model m,RedirectAttributes attributes)
	    {	
	    	supplierDAO.deleteSupplier(supId);
			return "redirect:/supplier";
			
	    }

}