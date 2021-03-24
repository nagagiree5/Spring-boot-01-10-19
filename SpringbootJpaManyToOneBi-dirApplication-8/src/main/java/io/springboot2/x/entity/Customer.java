package io.springboot2.x.entity;

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
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
//  @JoinColumn(name = "customerId_fk")
	private Set<Order> orders;
	
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

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", mobileNo=" + mobileNo + "]";
	}
}



















