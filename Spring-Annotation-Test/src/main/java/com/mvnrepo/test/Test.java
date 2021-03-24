package com.mvnrepo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mvnrepo.config.ApplicationConfig;
import com.mvnrepo.service.MovieService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ApplicationContext ctx=new AnnotationConfigApplicationContext(ApplicationConfig.class);
MovieService s=ctx.getBean("movieService",MovieService.class);
s.getListOfMoviesHere();
System.out.println("============");
	}

}
