package io.springboot2.x.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer {
	
	@Id
	private Integer customerId;
	
	@Column(length=25)
	private String customerName;
	
	
	private Long mobileNo;
	
	
	  public Customer() {
	  
	  }
	 
	public Customer(Integer customerId, String customerName, Long mobileNo) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNo = mobileNo;
		
	}

	
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", mobileNo=" + mobileNo + "]";
	}
}



















