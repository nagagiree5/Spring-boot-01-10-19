package com.pms.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pms.exception.NoSuchProductException;

@RestControllerAdvice
public class MyExceptionAdvice {
	
	@ExceptionHandler(NoSuchProductException.class)
	public  ErrorMessage  exHandler(NoSuchProductException  ex){
		ErrorMessage  em=new ErrorMessage();
		em.setCode(400);
		em.setMessage("Product does not exist");
		return  em;
	}
	

}
