package io.springboot2.x.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "products")
public class ProductListDTO implements Serializable {

	List<ProductDTO> products=new ArrayList<ProductDTO>();

	
	public List<ProductDTO> getProducts() {
		return products;
	}

	@XmlElement(name = "product")
	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}
	
}
