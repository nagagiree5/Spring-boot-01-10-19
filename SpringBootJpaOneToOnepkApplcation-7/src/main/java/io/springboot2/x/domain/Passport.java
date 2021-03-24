package io.springboot2.x.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Passport {

	@GenericGenerator(name = "f1",strategy="foreign",parameters =@Parameter(name="property" ,value = "person"))
	@Id
	@GeneratedValue(generator ="f1")
	private Integer passportid;

	@Temporal(TemporalType.DATE)
	private Date expiredate;

	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Person person;

	public Integer getPassportid() {
		return passportid;
	}

	public void setPassportid(Integer passportid) {
		this.passportid = passportid;
	}

	public Date getExpiredate() {
		return expiredate;
	}

	public void setExpiredate(Date expiredate) {
		this.expiredate = expiredate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Passport [passportid=" + passportid + ", expiredate=" + expiredate + "]";
	}

}
