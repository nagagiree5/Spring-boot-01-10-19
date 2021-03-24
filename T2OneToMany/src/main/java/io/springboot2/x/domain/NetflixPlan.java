package io.springboot2.x.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class NetflixPlan {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer planid;
	private String planname;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "planid_fk")
	private NetflixAcc netflixAcc;
	public Integer getPlanid() {
		return planid;
	}
	public void setPlanid(Integer planid) {
		this.planid = planid;
	}
	public String getPlanname() {
		return planname;
	}
	public void setPlanname(String planname) {
		this.planname = planname;
	}
	public NetflixAcc getNetflixAcc() {
		return netflixAcc;
	}
	public void setNetflixAcc(NetflixAcc netflixAcc) {
		this.netflixAcc = netflixAcc;
	}
	
	
	
	
	

}
