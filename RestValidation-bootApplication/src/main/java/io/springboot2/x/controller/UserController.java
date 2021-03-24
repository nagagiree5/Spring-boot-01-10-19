package io.springboot2.x.controller;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.springboot2.x.domain.User;
import io.springboot2.x.repository.UserRepository;

@RestController
@Validated
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
     
    @PostMapping("users/add")
    public ResponseEntity<String> addUser(@RequestBody @Valid User user) {
    	boolean flag=repo.existsById(user.getId());
    	if(flag==true) {
    		return ResponseEntity.ok("Id is alredy exist!...");
    	}
        repo.save(user);
        return ResponseEntity.ok("User data is added to database...");
    }
    
    @GetMapping("users/{id}")
    @Valid
    public Optional<User> getUser(@PathVariable @Positive Long id) {
        return repo.findById(id); 
        
    } 
    
    
    
    
    
    
    
}
