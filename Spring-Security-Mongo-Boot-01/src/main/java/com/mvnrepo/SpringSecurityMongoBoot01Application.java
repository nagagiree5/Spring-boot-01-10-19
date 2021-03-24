package com.mvnrepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@SpringBootApplication
public class SpringSecurityMongoBoot01Application {
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityMongoBoot01Application.class, args);
	}

	@Bean
	public ResourceBundleViewResolver viewResolver() {
		ResourceBundleViewResolver viewresolver = new ResourceBundleViewResolver();
		viewresolver.setBasename("views");
		return viewresolver;
	}

}
