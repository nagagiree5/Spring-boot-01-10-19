package io.springboot2.x.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="PASSENGER")   //optional
@NamedQueries({
              @NamedQuery(name="Passenger.byFirstName",
                                     query="select  passenger  from  Passenger  passenger  where passenger.firstName  like '%a%' ")
              
             })
public class Passenger {
	@Id
	Integer  passengerId;
	
	@Column(length=20)
	String    firstName;
	 
	@Column(length=20)
	String    lastName;
	
	@Column(length=30)
	String    emailId;
	
	Integer    age;
	
	@Column(length=10)
	String     gender;
	
	Integer   seatNumber;

	public Integer getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", age=" + age + ", gender=" + gender + ", seatNumber=" + seatNumber + "]";
	}
	
	
	

}
