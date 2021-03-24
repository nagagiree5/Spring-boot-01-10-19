package com.mvnrepo.service;

import java.util.List;
import java.util.Optional;

import com.mvnrepo.entity.EmployeeMongo;
import com.mvnrepo.entity.Gender;

public interface IRegisterMongoService {

	public   boolean   registerEmployee(String  fullName,  String  email,  Integer  experience,  Gender  gender,  java.util.Date  dateOfBirth);
	
	public   List<EmployeeMongo> getListOfEmployees();
	
	public   Optional<EmployeeMongo>  editEmployeePage(String  id) ;
	
	public   List<EmployeeMongo>    getUpdateEmployee(EmployeeMongo  employee);
     
	public   List<EmployeeMongo>    getDeleteEmployee(String  id) ;

	
	
	
	
	
} 