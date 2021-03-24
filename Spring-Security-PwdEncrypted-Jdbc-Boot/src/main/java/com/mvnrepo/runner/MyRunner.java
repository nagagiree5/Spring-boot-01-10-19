package com.mvnrepo.runner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.mvnrepo.repo.SpringSecurityPwdEncrypted;



@Service
public class MyRunner implements CommandLineRunner {

	@Autowired
	ApplicationContext ctx;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		SpringSecurityPwdEncrypted securityPwdEncrypted=ctx.getBean(SpringSecurityPwdEncrypted.class,"springSecurityPwdEncrypted");
		int i1=securityPwdEncrypted.insertDetails("admin", "admin", 0);
		int i2=securityPwdEncrypted.insertDetails("ceo", "ceo", 1);
		int i3=securityPwdEncrypted.insertDetails("manager", "manager", 1);
		
		System.out.println(i1+"-1st row..."+i2+"-2nd row..."+i3+"-3rd row...");
	}

}     




	
	
		
	
	

	
