
package com.spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dao.ProductDAO;
import com.spring.dao.UserDAO;
import com.spring.model.User;


@Controller
public class IndexController
{
	
	
@Autowired
 UserDAO userDao;

@Autowired
ProductDAO productDao;

 
 
 @RequestMapping(value="/",method=RequestMethod.GET)
public String showIndex(Model m)
{
m.addAttribute("plist", productDao.retrieveProduct());
	return "welcome";
}
@RequestMapping("/registration")
public String goToRegisterPage(@ModelAttribute("user") User user,Model model)
{
	
	model.addAttribute("user",new User());
	
	return "register";
}

@RequestMapping("/saveUser")
public String createUser(@ModelAttribute("user") User user)
{
 
	user.setRole("ROLE_USER");
	user.setEnabled(true);
	userDao.saveUser(user);
	return "welcome";
}


}