package com.pms.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="products")
public class ProductListDTO implements  java.io.Serializable {
	List<ProductDTO>  DtoList=new  ArrayList<ProductDTO>();

	@XmlElement(name="product")
	public List<ProductDTO> getDtoList() {
		return DtoList;
	}

	public void setDtoList(List<ProductDTO> dtoList) {
		DtoList = dtoList;
	}
	
	
}
