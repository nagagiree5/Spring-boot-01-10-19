package io.springboot2.x.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Passport {

	@Id
	private Integer passportid;

	@Temporal(TemporalType.DATE)
	private Date expiredate;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name ="personid_fk",unique =true,nullable=false)
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
