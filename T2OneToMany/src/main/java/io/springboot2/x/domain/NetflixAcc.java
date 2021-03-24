package io.springboot2.x.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "NETFLIXACC")
public class NetflixAcc {

	
	@Id
	private String netflixid;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date tenure;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "netflixacc")
	private Set<NetflixPlan> netflixPlans;

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

	public Set<NetflixPlan> getNetflixPlans() {
		return netflixPlans;
	}

	public void setNetflixPlans(Set<NetflixPlan> netflixPlans) {
		this.netflixPlans = netflixPlans;
	}

	
	
	

	

}
