package com.mvnrepo.service;

import java.util.List;
import java.util.Optional;

import com.mvnrepo.entity.EmployeeJpa;
import com.mvnrepo.entity.Gender;

public interface IRegisterJpaService {

	public   boolean   registerEmployee(String  fullName,  String  email,  Integer  experience,  Gender  gender,  java.util.Date  dateOfBirth);
	
	public   List<EmployeeJpa> getListOfEmployees();
	
	public   Optional<EmployeeJpa>  editEmployeePage(String  id) ;
	
	public   List<EmployeeJpa>    getUpdateEmployee(EmployeeJpa  employee);
     
	public   List<EmployeeJpa>    getDeleteEmployee(String  id) ;

	
	
	
	
	
} 