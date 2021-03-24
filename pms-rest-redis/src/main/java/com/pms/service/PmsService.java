package com.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.pms.dto.ProductDTO;
import com.pms.entity.Product;
import com.pms.exception.NoSuchProductException;
import com.pms.exception.ProductNotExistException;
import com.pms.repository.ProductRepository;

@Service
public class PmsService {
	@Autowired
	ProductRepository  repo;
	
	
	
	@Cacheable(value= "storeProducts",key="#root.methodName")
	public  List<Product>  getAllProducts() {
		return repo.findAll();
		
	}
	
	@CacheEvict(value="storeProducts", allEntries=true)
	@Scheduled(fixedDelay=20000)
	public  void  clearData() {
		//System.out.println("all entries are cleared from storeProducts cache");
	}
	
	
	@Cacheable(value="singleProduct", key="#productId", unless="#result.productId==null")
	public  ProductDTO  findProductById(Integer productId) {
		Optional<Product>  opt = repo.findById(productId);
		
		ProductDTO  pDTO=new  ProductDTO();
		if(opt.isPresent()) {
			Product  product = opt.get();
		   	BeanUtils.copyProperties(product, pDTO);
		}
		return pDTO;
	}
	
	
	public String storeProduct(Product product) {
		boolean  flag=repo.existsById(product.getProductId());
		if(flag == true) {
			return "product already exist";
		}
		else {
			repo.save(product);
			
			return  "product is added to Database";
		}
	}
	
	@CachePut(value="singleProduct", key="#pDTO.productId")
	public  ProductDTO  modifyProduct(ProductDTO pDTO) {
		Product   product =new  Product();
		BeanUtils.copyProperties(pDTO, product);
	
		boolean  flag=repo.existsById(product.getProductId());
		if(flag == true) {
			repo.saveAndFlush(product);
			return pDTO;
		}
		else {
			throw new ProductNotExistException();
		}
	}
	
	@CacheEvict(value="singleProduct", key="#productId")
	public  String  removeProduct(Integer  productId) {
		boolean  flag=repo.existsById(productId);
		if(flag==true) {
			repo.deleteById(productId);
			return  "The product is  deleted.";
			
		}
		else {
			//return  "Sorry, The product doesn't  exist";
			throw  new  NoSuchProductException();
		}
	}

}
