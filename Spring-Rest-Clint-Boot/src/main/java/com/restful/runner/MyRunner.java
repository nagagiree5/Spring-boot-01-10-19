package com.restful.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.restful.dto.UserDTO;


@Component
public class MyRunner implements ApplicationRunner {

	@Autowired
	ApplicationContext ctx;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
RestTemplate restTemplate = new RestTemplate();
		
		
		  ResponseEntity<List<UserDTO>>
		  re=restTemplate.exchange("http://localhost:4555/UserApi/users/all",
		  HttpMethod.GET,null,new ParameterizedTypeReference<List<UserDTO>>() {});
		  List<UserDTO> list = re.getBody(); for(UserDTO dto : list) {
		  System.out.println(dto.getUserId()); System.out.println(dto.getUserName());
		  System.out.println(dto.getPhoneNo());
		  System.out.println("================="); }
		 
		 

		
		/*
		 * ResponseEntity<UserDTO> re
		 * =restTemplate.exchange("http://localhost:4555/UserApi/users/222",
		 * HttpMethod.GET, null, new ParameterizedTypeReference<UserDTO>() {}); UserDTO
		 * dto = re.getBody(); System.out.println(dto.getUserId());
		 * System.out.println(dto.getUserName()); System.out.println(dto.getPhoneNo());
		 * System.out.println("==================");
		 */

		// create user
		
		
		/*
		 * UserDTO userDto=new UserDTO(); userDto.setUserId(103);
		 * userDto.setUserName("C"); userDto.setPhoneNo(89902431L); String str
		 * =restTemplate.postForObject("http://localhost:4555/UserApi/create", userDto,
		 * String.class); System.out.println(str);
		 */
		 
		 
		
		
		/*
		 * ResponseEntity<String> re=
		 * restTemplate.exchange("http://localhost:4555/UserApi/delete?userid=103",
		 * HttpMethod.DELETE, null, new ParameterizedTypeReference<String>() { });
		 * String message= re.getBody(); System.out.println(message);
		 * System.out.println("==========================");
		 */
		 
		 

}
}