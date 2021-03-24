package io.springboot2.x.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.springboot2.x.exception.NoSuchProductException;


@RestControllerAdvice
public class PMSRestControllerAdvice {
	
	@ExceptionHandler(NoSuchProductException.class)
	public     ResponseEntity<ErrorMessage>    exceptionHandler1(NoSuchProductException   e){
		ErrorMessage    errMessage=new  ErrorMessage();
		errMessage.setErrorCode("500");
		errMessage.setErrorMessage("User with given Id  doesn't exist in Database");
		return    new   ResponseEntity<ErrorMessage>(errMessage, HttpStatus.BAD_REQUEST);
	}
	

}  
