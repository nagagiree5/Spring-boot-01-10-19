package io.springboot2.x.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.NONE)
//@XmlAccessorType(XmlAccessType.FIELD)               //No need of @XmlElement
@ApiModel(description = "This is dto used to transfer product data...")
public class ProductDTO implements Serializable{

	//@XmlAttribute
	@XmlElement(name ="productId")
	@ApiModelProperty(notes = "This is id of product..,Which uniquely identifies a product...")
	private Integer productId;
	@XmlElement
	@ApiModelProperty(notes = "This is productName of product...")
	private String productName;
	@XmlElement
	@ApiModelProperty(notes = "This is price of product...")
	private Double price;
	@XmlElement
	@ApiModelProperty(notes = "This is manufacturer of product...")
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
