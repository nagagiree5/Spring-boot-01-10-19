package com.mvnrepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@SpringBootApplication
public class SpringJpaMvcBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaMvcBootApplication.class, args);
			
	}
	
	@Bean  
    public ResourceBundleViewResolver resourceBundleViewResolver() {  
	ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
	resolver.setBasename("views");
        return resolver;  
    }

}
