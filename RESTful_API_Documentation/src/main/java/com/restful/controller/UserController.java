package com.restful.controller;

import java.util.ArrayList
;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
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

import com.restful.dto.UserDTO;
import com.restful.entity.User;
import com.restful.exception.NoSuchUserException;
import com.restful.repo.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@Api("It is perform crud operation in database...")
public class UserController {                                                 //1.Try with diff end points or urls For version to Version
	@Autowired                                           //1.Same end points but in RequestMapping one more eliment params or headers For version to Version
	UserRepository      repo;
	
	@ApiOperation(value = "For return list of staff details staffid and staffname...", response = List.class)
	@ApiResponses({
		@ApiResponse(code =200,message ="It is to return list successful..."),
		@ApiResponse(code =400,message ="It is worng url check and try again..."),
		@ApiResponse(code =500,message ="Internal Server Error ..."),
		@ApiResponse(code =401,message ="Full authentication is required to access this resource..."),
		@ApiResponse(code =403,message ="Resourec is available but not access to this user...")
		
	})
	//@GetMapping(value="/users/v1/all",  produces="application/json")
	@GetMapping(value="/users/all",  produces="application/json",headers ="API-VERSION=1.0")
	//@GetMapping(value="/users/all",  produces="application/json",params = "version=1.0")
	public     ResponseEntity<List<UserDTO>>    findAllUsersV1() {
		List<User>    usersList = repo.findAll();
		List<UserDTO>  usersList2 = new  ArrayList<>();
		for(User   user :  usersList) {
			UserDTO     dto = new  UserDTO();
			dto.setUserId(user.getUserId());
			dto.setUserName(user.getUserName());
			usersList2.add(dto);
		}
		return    new  ResponseEntity<List<UserDTO>>(usersList2, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "For return list of staff details staffid,staffname and phnnor...", response = List.class)
	@ApiResponses({
		@ApiResponse(code =200,message ="It is to return list successful..."),
		@ApiResponse(code =400,message ="It is worng url check and try again..."),
		@ApiResponse(code =500,message ="Internal Server Error ..."),
		@ApiResponse(code =401,message ="Full authentication is required to access this resource..."),
		@ApiResponse(code =403,message ="Resourec is available but not access to this user...")
		
	})
	@GetMapping(value="/users/all",  produces="application/json",params = "version=2.0")
	public     ResponseEntity<List<UserDTO>>    findAllUsersV2() {
		List<User>    usersList = repo.findAll();
		List<UserDTO>  usersList2 = new  ArrayList<>();
		for(User   user :  usersList) {
			UserDTO     dto = new  UserDTO();
			dto.setUserId(user.getUserId());
			dto.setUserName(user.getUserName());
			dto.setPhoneNo(user.getPhoneNo());
			usersList2.add(dto);
		}
		return    new  ResponseEntity<List<UserDTO>>(usersList2, HttpStatus.OK);
	}
	

	
	@ApiOperation(value = "For return specific staff details based on staffid...", response = UserDTO.class)
	@ApiResponses({
		@ApiResponse(code =200,message ="It is to return list successful..."),
		@ApiResponse(code =400,message ="It is worng url check and try again..."),
		@ApiResponse(code =500,message ="Internal Server Error ..."),
		@ApiResponse(code =401,message ="Full authentication is required to access this resource..."),
		@ApiResponse(code =403,message ="Resourec is available but not access to this user...")
	
	})
	@GetMapping(value="/users/{userid}",  produces="application/json",headers= "version=1.0")
	public      UserDTO      findUserByIdV1(@PathVariable   Integer  userid) {
		Optional<User>      opt = repo.findById(userid);
		User   user=opt.get();
		UserDTO   dto=new  UserDTO();
		dto.setUserId(user.getUserId());
		dto.setUserName(user.getUserName());
		return   dto;

	}
	
	
	@ApiOperation(value = "For return specific staff details based on staffid...", response = UserDTO.class)
	@ApiResponses({
		@ApiResponse(code =200,message ="It is to return list successful..."),
		@ApiResponse(code =400,message ="It is worng url check and try again..."),
		@ApiResponse(code =500,message ="Internal Server Error ..."),
		@ApiResponse(code =401,message ="Full authentication is required to access this resource..."),
		@ApiResponse(code =403,message ="Resourec is available but not access to this user...")
	
	})
	@GetMapping(value="/users/{userid}",  produces="application/json",headers = "version=2.0")
	public      UserDTO      findUserByIdV2(@PathVariable   Integer  userid) {
		Optional<User>      opt = repo.findById(userid);
		User   user=opt.get();
		UserDTO   dto=new  UserDTO();
		dto.setUserId(user.getUserId());
		dto.setUserName(user.getUserName());
		dto.setPhoneNo(user.getPhoneNo());
		return   dto;

	}
	
	
	
	
	
	
	
	
	@ApiOperation(value = "For add staff details to database...", response = String.class)
	@ApiResponses({
		@ApiResponse(code =200,message ="It is to return list successful..."),
		@ApiResponse(code =400,message ="It is worng url check and try again..."),
		@ApiResponse(code =500,message ="Internal Server Error ..."),
		@ApiResponse(code =401,message ="Full authentication is required to access this resource..."),
		@ApiResponse(code =403,message ="Resourec is available but not access to this user...")
	
	})
	@PostMapping(value="/create",   consumes="application/json", produces="text/plain")
	public     String     createNewUser(@RequestBody   User  user)  throws  Exception {
		boolean  flag=repo.existsById(user.getUserId());
		if(flag==true) {
			throw   new   Exception();
		}
		repo.save(user);
		return   "User  is   Added   to   Database";
		
	}
	
	@ApiOperation(value = "For update staff details in database...", response = String.class)
	@ApiResponses({
		@ApiResponse(code =200,message ="It is to return list successful..."),
		@ApiResponse(code =400,message ="It is worng url check and try again..."),
		@ApiResponse(code =500,message ="Internal Server Error ..."),
		@ApiResponse(code =401,message ="Full authentication is required to access this resource..."),
		@ApiResponse(code =403,message ="Resourec is available but not access to this user...")
	
	})
	@PutMapping(value="/update",   consumes="application/json",  produces="text/plain")
	public      String      updateUser(@RequestBody   User   user) {
		repo.saveAndFlush(user);
		return    "User  is  Updated   to  Database";
	}
	
	@ApiOperation(value = "For delete specific staff details from database...", response = String.class)
	@ApiResponses({
		@ApiResponse(code =200,message ="It is to return list successful..."),
		@ApiResponse(code =400,message ="It is worng url check and try again..."),
		@ApiResponse(code =500,message ="Internal Server Error ..."),
		@ApiResponse(code =401,message ="Full authentication is required to access this resource..."),
		@ApiResponse(code =403,message ="Resourec is available but not access to this user...")
	
	})
	@DeleteMapping(value="/delete")
	public     String      deleteUser(@RequestParam("userid")   Integer   id) {
		boolean  flag=repo.existsById(id);
		if(flag==true) {
			repo.deleteById(id);
			return   "User  is  Deleted  from   Database";
		}
		else {
			throw   new   NoSuchUserException();
		}
	}
			
	

}
