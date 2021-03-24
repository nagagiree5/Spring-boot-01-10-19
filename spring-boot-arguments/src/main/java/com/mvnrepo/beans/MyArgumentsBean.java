package com.mvnrepo.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MyArgumentsBean {
    
	@Value("${person.setName}")
	private String setName;
	
	public String getName() {
		return setName;
	}
	
	
}
