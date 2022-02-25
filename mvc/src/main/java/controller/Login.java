package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.LoginService;

@Controller
public class Login {
	@RequestMapping("/login")
	public ModelAndView userLogin( @RequestParam("fullName") String name) {
//		System.out.println("Welcome controller");
		LoginService ls=new LoginService();
		boolean result=ls.validate(name);
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home.jsp");
		mv.addObject("name",name);
		return mv;
	}

}
