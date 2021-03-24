package com.pms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@EnableCaching
@EnableScheduling
public class PmsRestApplication implements  WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(PmsRestApplication.class, args);
	}
	
	
	  @Override
	  public void addCorsMappings(CorsRegistry registry) {
		  registry.addMapping("/**").allowedOrigins("*").allowedMethods("*"); 
	  }
	  
	  

}
