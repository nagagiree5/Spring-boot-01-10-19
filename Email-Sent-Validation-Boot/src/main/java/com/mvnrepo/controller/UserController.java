package com.mvnrepo.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvnrepo.beans.Country;
import com.mvnrepo.beans.UserBean;
import com.mvnrepo.repo.IEmailRepo;
import com.mvnrepo.serviceimpl.EmailService;


@Controller
public class UserController {
	@Autowired
	IEmailRepo  repo;
	
	@Autowired
	EmailService  service;
	
	@InitBinder
	public  void  initBinder(WebDataBinder  webDataBinder)
	{
		SimpleDateFormat  sdf=new SimpleDateFormat("dd/MM/yyyy");
		CustomDateEditor editor=new CustomDateEditor(sdf, true);
		webDataBinder.registerCustomEditor(Date.class, editor);
	}
	
	@GetMapping(value="/register")
	public  String  getRegistrationPage(Model  model) {
		List<Country>  countriesList=repo.getAllCountries();
		UserBean  userBean=new UserBean();
		userBean.setCountriesList(countriesList);
		model.addAttribute("userBean", userBean);
		return  "registration";
	}
	
	@PostMapping("/process")
	public   String  processRequest(@Valid @ModelAttribute  UserBean  userBean,BindingResult result, Model  model)
	{
		if(result.hasErrors()) {
			List<Country>  countriesList=repo.getAllCountries();
			userBean.setCountriesList(countriesList);
			model.addAttribute("userBean", userBean);
			return  "registration";
		}
		else {
			boolean flag = repo.saveUser(userBean);
			if(flag) {
				service.sendEmail(userBean.getEmail(), userBean.getUsername());
				return  "success";
			}
			else {
				return  "failure";
			}
		}
	}

}



