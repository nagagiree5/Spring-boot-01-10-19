package com.mvnrepo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class My_Controller {
	@GetMapping("/hello") //Short cut of @RequestMapping on spring 5.x on words...Apart from that no diff both are same... 
	public ModelAndView sayHello() {
		return new ModelAndView("viewPage");
		
	}  
}
