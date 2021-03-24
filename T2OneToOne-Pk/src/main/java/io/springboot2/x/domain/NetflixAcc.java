package io.springboot2.x.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class NetflixAcc {

	@GenericGenerator(name = "f1",strategy="foreign",parameters =@Parameter(name="property" ,value = "netflixUser"))
	@Id
	@GeneratedValue(generator ="f1")
	private String netflixid;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date tenure;

	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private NetflixUser netflixUser;

	public String getNetflixid() {
		return netflixid;
	}

	public void setNetflixid(String netflixid) {
		this.netflixid = netflixid;
	}

	public Date getTenure() {
		return tenure;
	}

	public void setTenure(Date tenure) {
		this.tenure = tenure;
	}

	public NetflixUser getNetflixUser() {
		return netflixUser;
	}

	public void setNetflixUser(NetflixUser netflixUser) {
		this.netflixUser = netflixUser;
	}

	

	

}
