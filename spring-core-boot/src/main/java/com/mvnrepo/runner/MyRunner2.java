package com.mvnrepo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
@Service
@Order(1)
public class MyRunner2 implements CommandLineRunner {
	@Autowired
	ApplicationContext ctx;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
       System.out.println("I am MyRunner2...");
	}

}
