package io.springboot2.x.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
	@Id
	private Integer personid;
	@Column(length = 25)
	private String personname;
	
	
	public Integer getPersonid() {
		return personid;
	}
	public void setPersonid(Integer personid) {
		this.personid = personid;
	}
	public String getPersonname() {
		return personname;
	}
	public void setPersonname(String personname) {
		this.personname = personname;
	}
	@Override
	public String toString() {
		return "Person [personid=" + personid + ", personname=" + personname + "]";
	}
	

}
