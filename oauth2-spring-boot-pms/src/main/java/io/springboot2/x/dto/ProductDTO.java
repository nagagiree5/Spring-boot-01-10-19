package io.springboot2.x.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.NONE)
//@XmlAccessorType(XmlAccessType.FIELD)               //No need of @XmlElement
public class ProductDTO implements Serializable{

	//@XmlAttribute
	@XmlElement(name ="productId")

	private Integer productId;
	@XmlElement

	private String productName;
	@XmlElement

	private Double price;
	@XmlElement

	private String manufacturer;
	
	
	public Integer getProductId() {
		return productId;
	}    
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	
}
