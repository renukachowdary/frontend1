package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.dao.CartDAO;
import com.spring.dao.ProductDAO;
import com.spring.model.Cart;
import com.spring.model.Product;

@Controller
public class CartController
{
	
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDao;
	

	  @RequestMapping(value="addToCart/{id}")
	    public String addProductToCart(@PathVariable("id") int id, HttpSession session,Model model,RedirectAttributes attributes)
	    {
	    	int userId = (Integer) session.getAttribute("userid");
	    	int q=1;
	    	if (cartDAO.getitem(id, userId) != null) {
				Cart item = cartDAO.getitem(id, userId);
				
				item.setProductQuantity(item.getProductQuantity() + q);
				
				Product p = productDao.getProduct(id);
				
				System.out.println(item);
				item.setPrice(p.getPrice());
				item.setSubTotal(item.getProductQuantity() *p.getPrice());
				cartDAO.saveProductToCart(item);
				attributes.addFlashAttribute("ExistingMessage",  p.getProductName() +"is already exist");
				return "redirect:/cart";
			} else {
				Cart item = new Cart();
				Product p = productDao.getProduct(id);
				item.setProductId(p.getProductId());
				item.setProductName(p.getProductName());
				item.setUserId(userId);
				item.setPrice(p.getPrice());
				item.setProductQuantity(q);
				item.setSubTotal(q * p.getPrice());
				cartDAO.saveProductToCart(item);
				attributes.addFlashAttribute("SuccessMessage", "Item"+p.getProductName()+" has been deleted Successfully");
				return "redirect:/cart";
			}
	    	
	    }
	   
	  @RequestMapping("cart")
		public String viewCart(Model model, HttpSession session) {
	    	
			int userId = (Integer) session.getAttribute("userid");
			model.addAttribute("CartList", cartDAO.listCartbyUserId(userId));
			 if(cartDAO.cartsize((Integer) session.getAttribute("userid"))!=0){
				
				model.addAttribute("CartPrice", cartDAO.CartPrice((Integer) session.getAttribute("userid")));
			} else {
				model.addAttribute("EmptyCart", "true");
			}
			model.addAttribute("IfcartClicked", "true");
		//	model.addAttribute("HideOthers", "true");
			return "Cart";
		}
	  
	  @RequestMapping("editCart/{cartid}")
		public String editorder(@PathVariable("cartid") int cartid, @RequestParam("quantity") int q, HttpSession session) {
		
			//int userId = (Integer) session.getAttribute("userid");
			Cart cart = cartDAO.editCartById(cartid);
			
			Product p = productDao.getProduct(cart.getProductId());
			cart.setProductQuantity(q);
			//cart.setProductPrice(q * p.getPrice());
			cart.setSubTotal(q * p.getPrice());
			cartDAO.saveProductToCart(cart);
			session.setAttribute("cartsize", cartDAO.cartsize((Integer) session.getAttribute("userid")));
			return "redirect:/cart";
		}
	    
	    
	    
	    
	@RequestMapping(value="removeCart/{id}")
	public String deleteorder(@PathVariable("id") int id, HttpSession session) {
		cartDAO.removeCartById(id);
		session.setAttribute("cartsize", cartDAO.cartsize((Integer) session.getAttribute("userid")));
		return "redirect:/cart";
	}



	

}