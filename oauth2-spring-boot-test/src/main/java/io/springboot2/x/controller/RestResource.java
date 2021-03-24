package io.springboot2.x.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.springboot2.x.model.UserProfile;

@RestController
public class RestResource {

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
	
}
