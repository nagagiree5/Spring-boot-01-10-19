package com.mvnrepo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvnrepo.beans.RegisterBean;
import com.mvnrepo.service.IRegisterService;

@Controller
public class RegisterController {

	@Autowired
	IRegisterService service;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		CustomDateEditor dateEditor = new CustomDateEditor(sdf, true);
		webDataBinder.registerCustomEditor(Date.class, dateEditor);
	}

	@GetMapping("/registerPage")
	public String returnRegisterPage(ModelMap modelMap) {
		RegisterBean registerBean = new RegisterBean();
		modelMap.addAttribute("register", registerBean);
		return "register";
	}

	@PostMapping("/registerUser")
	public String registerUser(@Valid @ModelAttribute("register") RegisterBean registerBean, BindingResult result) {
		if (result.hasErrors()) {
			return "register";
		} else {
			boolean flag = service.getRegisterUser(registerBean);
			if (flag == true) {
				return "getDetails";
			} else {
				return "isAlredyExist";
			}

		}
	}

}
