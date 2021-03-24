package com.mvnrepo.beans;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class RegisterBean {
	@Size(min=6, max=15)
	private  String  fullName;
	
	
	@NotNull
	@Email
    private  String  email;
	
	@Min(5)
	@Max(20)
	private  int  experience;
	
	@NotNull
	private  Gender  gender;
	
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

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public java.util.Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(java.util.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	

}
