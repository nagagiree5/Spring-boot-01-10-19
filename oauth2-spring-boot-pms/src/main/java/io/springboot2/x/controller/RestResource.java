package io.springboot2.x.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
import io.springboot2.x.dto.UserProfile;
import io.springboot2.x.exception.NoSuchProductException;
import io.springboot2.x.repository.ProductRepository;

@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RestResource {

	@Autowired
	private ProductRepository repo;
	
	@GetMapping("/api/users/me")
	public ResponseEntity<UserProfile> profile(){
		
		//Build some duplicate data to return for testing
		User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email=user.getUsername()+"@pivotalteam.com";
		
		UserProfile profile =new UserProfile();
		profile.setName(user.getUsername());
		profile.setEmail(email);
		
		return ResponseEntity.ok(profile);
	}

	// versioning...
	@GetMapping(value = "/api/products", produces = "application/json")
	// @GetMapping(value = "/v1/products", produces = "application/json")
	// //Versioning in url...
	// @GetMapping(value = "/products", produces = "application/json",headers =
	// "API-VERSION=1.0") //versionig in header...

	// @GetMapping(value = "/products", produces = "application/json",params
	// ="version=1.0") //versionig in param...

	// @CrossOrigin(origins = "*")
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

	// @GetMapping(value = "/v2/products", produces = "application/xml")
	// @GetMapping(value = "products", produces = "application/xml",headers =
	// "API-VERSION=2.0")
	@GetMapping(value = "/api/products", produces = "application/xml", params = "version=2.0")

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

	@GetMapping(value = "/api/product/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Integer id) {

		Optional<Product> opt = repo.findById(id);

		ProductDTO productDto = new ProductDTO();
		if (opt.isPresent()) {
			Product product = opt.get();
			BeanUtils.copyProperties(product, productDto);
			return new ResponseEntity<ProductDTO>(productDto, HttpStatus.OK);

		}
		throw new NoSuchProductException();
		// return new ResponseEntity<ProductDTO>(productDto, HttpStatus.OK);

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

	@PostMapping(value = "/api/product/create", consumes = { "application/json",
			"application/xml" }, produces = "text/plain")
	public String addProduct(@RequestBody ProductDTO productDto) /* throws Exception */ {
		Product product = new Product();
		BeanUtils.copyProperties(productDto, product);
		boolean flag = repo.existsById(product.getProductId());
		if (flag == true) {
			return "Sorry..,The product is alredy exist...";
			// throw new Exception();
		}
		repo.save(product);
		return "The product is added...";

	}

	@PutMapping(value = "/api/product/update", consumes = { "application/json", "application/xml" })
	public String updateProduct(@RequestBody ProductDTO productDto) {
		Product product = new Product();
		BeanUtils.copyProperties(productDto, product);
		boolean flag = repo.existsById(product.getProductId());
		if (flag == true) {
			repo.saveAndFlush(product);
			return "The product is updated...";
		}
		return "Sorry..,The product is does not exist...";

	}

	@DeleteMapping("/api/product/delete")
	public String updateProduct(@RequestParam("id") Integer id) {
		boolean flag = repo.existsById(id);
		if (flag == true) {
			repo.deleteById(id);
			return "The product is deleted...";
		}
		// return "Sorry..,The product is does not exist...";
		throw new NoSuchProductException();

	}

}
