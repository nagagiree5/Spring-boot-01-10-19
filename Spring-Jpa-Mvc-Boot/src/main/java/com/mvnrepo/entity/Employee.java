package com.mvnrepo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="EMP_TAB")
public class Employee {
	  
	
	@Size(min=6, max=15)
	@Column(length=25)
    private  String  fullName;
	

	@NotNull
	@Email
	@Id
	@Column(length=35)
    private  String  email;
	
	@Min(5)
	@Max(20)
	private  Integer  experience;
	
	//Setters&Getters
	@NotNull
	@Column(name =" gender", length=10)
	private  String  gender;
	
	@NotNull
	@Past
	@DateTimeFormat(pattern="yyyy.MM.dd")
    private  java.util.Date  dateOfBirth;

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
