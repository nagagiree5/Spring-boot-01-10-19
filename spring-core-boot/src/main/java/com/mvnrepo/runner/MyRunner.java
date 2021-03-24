package com.mvnrepo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.mvnrepo.bean.HelloBean;

@Service
public class MyRunner implements CommandLineRunner {

	@Autowired
	ApplicationContext ctx;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		HelloBean helloBean=ctx.getBean(HelloBean.class,"helloBean");
	
		System.out.println(helloBean.sayHello());
	}

}   




	
	
		
	
	

	
