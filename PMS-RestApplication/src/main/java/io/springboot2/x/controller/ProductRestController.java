package io.springboot2.x.controller;

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

import io.springboot2.x.domain.Product;
import io.springboot2.x.dto.ProductDTO;
import io.springboot2.x.dto.ProductListDTO;
import io.springboot2.x.exception.NoSuchProductException;
import io.springboot2.x.repository.ProductRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductRestController {

	@Autowired
	private ProductRepository repo;

	// versioning...
	@GetMapping(value = "/products", produces = "application/json")
	//@GetMapping(value = "/v1/products", produces = "application/json") //Versioning in url...
	//@GetMapping(value = "/products", produces = "application/json",headers = "API-VERSION=1.0")  //versionig in header...
	
	//@GetMapping(value = "/products", produces = "application/json",params ="version=1.0")  //versionig in param...

	@ApiOperation(value = "This is version 1.0 of rest end point fetches all products in JSON Formate...", response = List.class, produces = "application/json")
	@ApiResponses({
		@ApiResponse(code=200, message="The products are fetched from Database successfully"),
		@ApiResponse(code=404, message="Check the endpoint url once before making a request"),
		@ApiResponse(code=403, message="The Resource is available but not accessible to you"),
		@ApiResponse(code =500,message ="Internal Server Error ..."),
		@ApiResponse(code =401,message ="Full authentication is required to access this resource...")
	})
	//@CrossOrigin(origins = "*")
	public ResponseEntity<List<ProductDTO>> getAllProductsV1() {
		List<Product> listOfProducts = repo.findAll();

		List<ProductDTO> listOfProductsDto = new ArrayList<>();
		listOfProducts.forEach(product -> {
			ProductDTO productDto = new ProductDTO();
			BeanUtils.copyProperties(product, productDto);
			listOfProductsDto.add(productDto);
		});

		return new ResponseEntity<List<ProductDTO>>(listOfProductsDto, HttpStatus.OK);

	}

	// For Xml responce...

	//@GetMapping(value = "/v2/products", produces = "application/xml")
	//@GetMapping(value = "products", produces = "application/xml",headers = "API-VERSION=2.0")
	@GetMapping(value = "/products", produces = "application/xml",params ="version=2.0")
	
	@ApiOperation(value = "This is version 2.0 of rest end point fetches all products in xml Formate...", response = ProductListDTO.class)
	@ApiResponses({
		@ApiResponse(code =200,message ="It is to return list successful..."),
		@ApiResponse(code =400,message ="It is worng url check and try again..."),
		@ApiResponse(code =500,message ="Internal Server Error ..."),
		@ApiResponse(code =401,message ="Full authentication is required to access this resource..."),
		@ApiResponse(code =403,message ="Resourec is available but not access to this user...")
		
	})
	public ResponseEntity<ProductListDTO> getAllProductsV2() {
		List<Product> listOfProducts = repo.findAll();

		List<ProductDTO> listOfProductDTO = new ArrayList<>();

		listOfProducts.forEach(product -> {
			ProductDTO productDTO = new ProductDTO();
			BeanUtils.copyProperties(product, productDTO);
			listOfProductDTO.add(productDTO);
		});

		ProductListDTO listDto = new ProductListDTO();
		listDto.setProducts(listOfProductDTO);
		return new ResponseEntity<ProductListDTO>(listDto, HttpStatus.OK);

	}

	/*
	 * @GetMapping(value = "/product/{id}", produces = { "application/json",
	 * "application/xml" }) public ResponseEntity<ProductDTO>
	 * getProductById(@PathVariable("id") Integer id) {
	 * 
	 * Optional<Product> opt = repo.findById(id);
	 * 
	 * ProductDTO productDto = new ProductDTO(); if (opt.isPresent()) { Product
	 * product = opt.get(); BeanUtils.copyProperties(product, productDto); return
	 * new ResponseEntity<ProductDTO>(productDto, HttpStatus.OK);
	 * 
	 * } return new ResponseEntity<ProductDTO>(productDto, HttpStatus.OK);
	 * 
	 * }
	 */
	
	@ApiOperation(value = "This rest end point get product by id from database...", response = ProductDTO.class)
	@ApiResponses({
		@ApiResponse(code =200,message ="It is to return list successful..."),
		@ApiResponse(code =400,message ="It is worng url check and try again..."),
		@ApiResponse(code =500,message ="Internal Server Error ..."),
		@ApiResponse(code =401,message ="Full authentication is required to access this resource..."),
		@ApiResponse(code =403,message ="Resourec is available but not access to this user...")
		
	})
	@GetMapping(value = "/product/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<ProductDTO> getProductById(@ApiParam("Product id")@PathVariable("id") Integer id) {

		Optional<Product> opt = repo.findById(id);

		ProductDTO productDto = new ProductDTO();
		if (opt.isPresent()) { 
			Product product = opt.get();
			BeanUtils.copyProperties(product, productDto);
			return new ResponseEntity<ProductDTO>(productDto, HttpStatus.OK);

		}
		throw new NoSuchProductException();
		//return new ResponseEntity<ProductDTO>(productDto, HttpStatus.OK);

	}

	/*
	 * @GetMapping(value = "/product/{id}",produces ={"application/json",
	 * "application/xml"})
	 * 
	 * public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Integer
	 * id){ boolean flag=repo.existsById(id); Optional<Product>
	 * opt=repo.findById(id); if(flag==true) { ProductDTO productDto=new
	 * ProductDTO(); //if(opt.isPresent()) { //Is present then copyProperties if not
	 * copy allProperties are null...To avid 500 Excepton here... if Product
	 * product=opt.get(); BeanUtils.copyProperties(product, productDto); return new
	 * ResponseEntity<ProductDTO>(productDto,HttpStatus.OK); //return new
	 * ResponseEntity<ProductDTO>(productDto,HttpStatus.OK); //} } throw new
	 * NoSuchProductException();
	 * 
	 * }
	 */

	/*
	 * @GetMapping("/product/{id}")
	 * 
	 * public ResponseEntity<Object> getProductById(@PathVariable("id") Integer id){
	 * boolean flag=repo.existsById(id); Optional<Product> opt=repo.findById(id);
	 * ProductDTO productDto=new ProductDTO(); if(flag==true) {
	 * 
	 * //if(opt.isPresent()) { //Is present then copyProperties if not copy
	 * allProperties are null...To avid 500 Excepton here... if Product
	 * product=opt.get(); BeanUtils.copyProperties(product, productDto); return new
	 * ResponseEntity<Object>(productDto,HttpStatus.OK); //return new
	 * ResponseEntity<ProductDTO>(productDto,HttpStatus.OK); //} } //throw new
	 * NoSuchProductException(); return new
	 * ResponseEntity<Object>("   Sorry!,Given id does not exist...",HttpStatus.
	 * NOT_FOUND);
	 * 
	 * }
	 */

	@ApiOperation(value = "This rest end point adds a new product to database...", response = String.class)
	@ApiResponses({
		@ApiResponse(code =200,message ="It is to return list successful..."),
		@ApiResponse(code =400,message ="It is worng url check and try again..."),
		@ApiResponse(code =500,message ="Internal Server Error ..."),
		@ApiResponse(code =401,message ="Full authentication is required to access this resource..."),
		@ApiResponse(code =403,message ="Resourec is available but not access to this user...")
		
	})
	@PostMapping(value = "/product/create", consumes = { "application/json", "application/xml" },produces="text/plain")
	public String addProduct(@ApiParam("A product data in JSON/XML")@RequestBody ProductDTO productDto) /* throws Exception */{
		Product product = new Product();  
		BeanUtils.copyProperties(productDto, product);
		boolean flag = repo.existsById(product.getProductId());
		if (flag == true) {
			return "Sorry..,The product is alredy exist...";
			//throw new Exception();
		}
		repo.save(product);
		return "The product is added...";

	}
	
	
	@ApiOperation(value = "This rest end point update product data in database...", response = String.class)
	@ApiResponses({
		@ApiResponse(code =200,message ="It is to return list successful..."),
		@ApiResponse(code =400,message ="It is worng url check and try again..."),
		@ApiResponse(code =500,message ="Internal Server Error ..."),
		@ApiResponse(code =401,message ="Full authentication is required to access this resource..."),
		@ApiResponse(code =403,message ="Resourec is available but not access to this user...")
		
	})
	@PutMapping(value = "/product/update", consumes = { "application/json", "application/xml" })
	public String updateProduct(@ApiParam("A product data in JSON/XML")@RequestBody ProductDTO productDto) {
		Product product = new Product();
		BeanUtils.copyProperties(productDto, product);
		boolean flag = repo.existsById(product.getProductId());
		if (flag == true) {
			repo.saveAndFlush(product);
			return "The product is updated...";
		}
		return "Sorry..,The product is does not exist...";

	}

	@ApiOperation(value = "This rest end point delete product from database...", response = String.class)
	@ApiResponses({
		@ApiResponse(code =200,message ="It is to return list successful..."),
		@ApiResponse(code =400,message ="It is worng url check and try again..."),
		@ApiResponse(code =500,message ="Internal Server Error ..."),
		@ApiResponse(code =401,message ="Full authentication is required to access this resource..."),
		@ApiResponse(code =403,message ="Resourec is available but not access to this user...")
		
	})
	@DeleteMapping("/product/delete")
	public String updateProduct(@RequestParam("id") Integer id) {
		boolean flag = repo.existsById(id);
		if (flag == true) {
			repo.deleteById(id);
			return "The product is deleted...";
		}
		//return "Sorry..,The product is does not exist...";
		throw new NoSuchProductException();

	}

}
