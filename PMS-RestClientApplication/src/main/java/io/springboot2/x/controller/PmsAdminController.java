package io.springboot2.x.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import io.springboot2.x.model.ProductDTO;

@Controller
public class PmsAdminController {

	@Autowired
   private RestTemplate restTemplate;
	
	@Value("${ADD_PRODUCT_URL}")
	private   String ADD_PRODUCT_URL;
	@Value("${UPDATE_PRODUCT_URL}")
	private   String UPDATE_PRODUCT_URL;
	@Value("${DELETE_PRODUCT_URL}")
	private   String DELETE_PRODUCT_URL;

	@Value("${FETCH_PRODUCTS_URL}")
	private String FETCH_PRODUCTS_URL;
	@Value("${FETCH_PRODUCT_URL}")
	private   String FETCH_PRODUCT_URL;
	
	
	
	@GetMapping({"/", "/index"})
	public String getIndex() {
		return "index";
	}
	@GetMapping("/addProduct")
	public String getAddProduct(Model model) {
		ProductDTO dto=new ProductDTO();
		model.addAttribute("product",dto);
		return "addProductPage";
		
	}
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("product")ProductDTO dto,Model model) {
		//postForObject(url, request, responseType) has 3Parameters...
		//Param1 req url, Param2 Java obj send in req, Param3 Class obj of responceType...
		
		String str=restTemplate.postForObject(ADD_PRODUCT_URL, dto, String.class);
		String responce="ADD_PRODUCT_URL is [ "+ADD_PRODUCT_URL+" ]..,Responce is: [ "+str+ " ]";
		System.out.println(str);
		model.addAttribute("str",str);
		return "index";
		
	}
	@GetMapping("/updateProduct")
	public String getUpdateProductPage(Model model) {
		ProductDTO dto=new ProductDTO();
		model.addAttribute("product2", dto);
		return "updateProduct";
	}
	
	
	
	@PostMapping("/update")
	public String updateProduct(@ModelAttribute("product2") ProductDTO dto,Model model) {
		
		
		//For add headers...
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);   //For POST urls use Content-Type headers
		headers.add("Content-Type", "application/json");      //If you know the header name use add method...If you dont know header use setHeadername method...
		
		
	
		//HttpEntity<ProductDTO> requestEntity=new HttpEntity<ProductDTO>(dto);
		HttpEntity<ProductDTO> requestEntity=new HttpEntity<ProductDTO>(dto,headers);
		
		//exchange(url, method, requestEntity, responseType) has 4params...
		//Pram1 is rest end point url, Param2 is HttpMethod, Param3 is HttpEntity it is an entity with headers and/or body to add the req..;
		//Param4 is Class obj of responce...
		
		ResponseEntity<String> res=restTemplate.exchange(UPDATE_PRODUCT_URL, HttpMethod.PUT, requestEntity,String.class);
		System.out.println(res.getBody());
		model.addAttribute("str",res.getBody());
		return "index";
		
	}
	@GetMapping("/deleteProduct")
	public String getDeleteProductPage() {
		return "deleteProduct";
		
	}
	@GetMapping("/delete")
	public String deletePorduct(@RequestParam("id") Integer id,Model model) {
		

		//ResponseEntity<String> res=restTemplate.exchange(DELETE_PRODUCT_URL+"?productid="+id,HttpMethod.DELETE,null,String.class);
		ResponseEntity<String>  res = restTemplate.exchange(DELETE_PRODUCT_URL+"?id="+id,HttpMethod.DELETE,null,String.class );
		System.out.println(res.getBody());
		model.addAttribute("str",res.getBody());
		return "index";
		
	}
	
	@GetMapping("/findAllProducts")
	public String findAllProducts(Model model) {
		
		 ParameterizedTypeReference<List<ProductDTO>> typeRef = new ParameterizedTypeReference<List<ProductDTO>>() {};
		 
		 HttpHeaders headers=new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));   //For GET urls use Accept headers
			headers.add("Accept", "application/json"); 
			
			HttpEntity<ProductDTO> requestEntity=new HttpEntity<ProductDTO>(headers);
		 
		 
		 
		 
		 
		 
		// ResponseEntity<List<ProductDTO>> res=restTemplate.exchange(FETCH_PRODUCTS_URL,HttpMethod.GET, null, typeRef);
		 ResponseEntity<List<ProductDTO>> res=restTemplate.exchange(FETCH_PRODUCTS_URL,HttpMethod.GET, requestEntity, typeRef);
		 
		 List<ProductDTO> listOfProducts=res.getBody();
		 model.addAttribute("products", listOfProducts);
		  
		return "getAllProducts";
		
	}
	
	@GetMapping("/findProduct")
	public String getFindProductByIdPage() {
		return "findProduct";
		
	}

	@GetMapping("/find")
	public String findProductsById(@RequestParam("id") Integer id,Model model) {
		
		 ParameterizedTypeReference<Optional<ProductDTO>> typeRef = new ParameterizedTypeReference<Optional<ProductDTO>>() {};
		 
		 ResponseEntity<Optional<ProductDTO>> res=restTemplate.exchange(FETCH_PRODUCT_URL+id,HttpMethod.GET, null, typeRef);
		 Optional<ProductDTO> opt=res.getBody();
		 ProductDTO product =opt.get();
		 model.addAttribute("pr", product);
		 System.out.println(res.getBody().get().getProductId());
		 
		 if(res.getBody().get().getProductId()==null) {
			 String str="Sorry id ["+id+"] is not exist...";
			 model.addAttribute("str", str);
			return "index"; 
		 }
		  
		return "getProduct";
		
	}
	
	
}
