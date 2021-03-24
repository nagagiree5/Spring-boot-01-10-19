package io.springboot.mvn.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import io.springboot.mvn.service.CustomerService;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
	@Autowired
	private ApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		CustomerService customerService = ctx.getBean("customerService", CustomerService.class);
		System.out.println(customerService);


	}

}
