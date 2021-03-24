package com.mvnrepo.service;

import java.util.List;
import java.util.Optional;

import com.mvnrepo.entity.Employee;
import com.mvnrepo.entity.Gender;

public interface IRegisterService {

	public   boolean   registerEmployee(String  fullName,  String  email,  Integer  experience,  Gender  gender,  java.util.Date  dateOfBirth);
	
	public   List<Employee> getListOfEmployees();
	
	public   Optional<Employee>  editEmployeePage(String  id) ;
	
	public   List<Employee>    getUpdateEmployee(Employee  employee);
     
	public   List<Employee>    getDeleteEmployee(String  id) ;

	
	
	
	
	
} 