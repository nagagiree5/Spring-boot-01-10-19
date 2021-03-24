package com.mvnrepo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvnrepo.entity.Employee;
import com.mvnrepo.entity.Gender;
import com.mvnrepo.service.IRegisterService;


@Controller
public class RegisterController {

	@Autowired
	IRegisterService service;
	
	@InitBinder
	public  void  initBinder(WebDataBinder  webDataBinder)
	{
		SimpleDateFormat  sdf=new SimpleDateFormat("yyyy.MM.dd");
		CustomDateEditor dateEditor=new CustomDateEditor(sdf, true);
		webDataBinder.registerCustomEditor(Date.class, dateEditor);
	}  
	
	
	@GetMapping("/getRegisterPage")
	public   String     getEmployeePage() {
		return   "registerPage";
	}
	
	
	@PostMapping("/getRegister")
	public    ModelAndView    registerEmployee(@RequestParam String  fullName, @RequestParam String  email, @RequestParam  Integer  experience, @RequestParam  Gender  gender, @RequestParam  java.util.Date  dateOfBirth) {
			
			
			boolean   flag = service.registerEmployee(fullName, email, experience, gender, dateOfBirth);
		    if(flag !=true) {
		    	return     new  ModelAndView("linksPage",  "message","Sorry, employee already exists!!!");
		    }
		    else {
		    
		    	return    new   ModelAndView("linksPage",  "message",  "Employee  added to Database");
		    }
	}  
	 	
	
	@GetMapping("/listOfEmployees")
	public   String     listOfEmployees(ModelMap   modelMap) {
		List<Employee>  getList = service.getListOfEmployees();
		modelMap.addAttribute("employees",getList);
		return   "getListOfEmployees";
	}
	@GetMapping("/editEmployeePage")
	public   String      getEditEmployeePage(@RequestParam("email")String  id,ModelMap   modelMap) {
		Optional<Employee>   opt = service.editEmployeePage(id);
		Employee    employee=opt.get();
		modelMap.addAttribute("e",employee);
		return   "getEditEmployee";
	}
	
	@PostMapping("/updateEmployee")
	public    String    updateEmployee(@ModelAttribute("e")Employee  employee, ModelMap  modelMap) {
		List<Employee>  empList = service.getUpdateEmployee(employee);
		modelMap.addAttribute("employees", empList);
		return   "getListOfEmployees";
		 
	}
	
	@GetMapping("/deleteEmployee")
	public    String    deleteEmployee(@RequestParam("email")String  id, ModelMap   modelMap) {
	
		List<Employee>  empList = service.getDeleteEmployee(id);
		modelMap.addAttribute("employees", empList);
		return   "getListOfEmployees";
		
	
	}
	@GetMapping("/login")
	public    String    getLoginPage(@RequestParam(value = "error",required=false)String  err, ModelMap   modelMap) {
		
		
	String errorMessage=""; //Empty or null what ever it ...
			
	if("true".equals(err)) {         //For avoid NullPointerException...If condition like this ..,If apply any method on null get null pointer exception...
		errorMessage="Not accessible...";
		modelMap.addAttribute("errorMessage",errorMessage);
	}
		
		return "login";

	}
		
	
}







