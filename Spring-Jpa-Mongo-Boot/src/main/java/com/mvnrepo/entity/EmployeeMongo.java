package com.mvnrepo.entity;


import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection ="EMP_TAB" )
public class EmployeeMongo {
	  
	
	@Size(min=6, max=15)
	private  String  fullName;
	

	@NotNull
	@Email
	@Id 
	String  email;
	
	@Min(5)  
	@Max(20)
	private  Integer  experience;
	
	
	@NotNull
	private  String  gender;
	
	@NotNull
	@Past
	@DateTimeFormat(pattern="yyyy.MM.dd")
    private  java.util.Date  dateOfBirth;

	
	//Setters&Getters
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public java.util.Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(java.util.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
    
    


  

}
