package com.pms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.dto.ProductDTO;
import com.pms.dto.ProductListDTO;
import com.pms.entity.Product;
import com.pms.exception.NoSuchProductException;
import com.pms.repository.ProductRepository;
import com.pms.service.PmsService;


@RestController

public class ProductRestController {
		
	@Autowired
	PmsService  service;
	
	
	@GetMapping(value="/products",  produces= {"application/json","application/xml"})
	
	public   ResponseEntity<ProductListDTO>   getProducts() {
		long x=System.currentTimeMillis();
		List<Product>   productsList = service.getAllProducts();
		long y=System.currentTimeMillis();
		
		System.out.println("Time to process /products url :"+(y-x) +" millis");
		
		List<ProductDTO>  productsDtoList = new  ArrayList<>();
		
		productsList.forEach( product -> {
			ProductDTO   pDTO =new  ProductDTO();
			BeanUtils.copyProperties(product, pDTO);
			productsDtoList.add(pDTO);
		});
		
		ProductListDTO  listDto =new  ProductListDTO();
		listDto.setDtoList(productsDtoList);
		
		return   new  ResponseEntity<ProductListDTO>(listDto,HttpStatus.OK);
	}
		
	
	@GetMapping(value="/products/{productid}", produces= {"application/json", "application/xml"})
	public   ResponseEntity<ProductDTO>   getProductById(@PathVariable("productid") Integer  productId) {
		ProductDTO pDTO=service.findProductById(productId);
		
		return   new  ResponseEntity<ProductDTO>(pDTO, HttpStatus.OK);
	}
	
	
	@PostMapping(value="/product/create",  consumes= {"application/xml", "application/json"},  produces="text/plain")
	public   String   createProduct(@RequestBody   ProductDTO   pDTO) {
		
		Product   product =new  Product();
		BeanUtils.copyProperties(pDTO, product);
		return  service.storeProduct(product);
		
	}
	
	
	@PutMapping("/product/update")
	public   String   updateProduct(@RequestBody   ProductDTO   pDTO) {
		try {
			service.modifyProduct(pDTO);
			return "product is updated in Database";
		}
		catch(Exception e) {
			return "product doesn't exist";
		}
						
	}
	
	
	@DeleteMapping("/product/delete")
	public   String   deleteProduct(@RequestParam("productid") Integer   productId) throws NoSuchProductException {
		
		return service.removeProduct(productId);
	}
	
}
