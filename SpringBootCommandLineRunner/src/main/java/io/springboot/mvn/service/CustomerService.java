package io.springboot.mvn.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
@Value("${cust.id}")
private Integer id;
@Value("${cust.name}")
private String name;
@Value("${cust.mobile}")
private Long mobileNor;

@Override
public String toString() {
	return "CustomerService [id=" + id + ", name=" + name + ", mobileNor=" + mobileNor + "]";
}

	
}
