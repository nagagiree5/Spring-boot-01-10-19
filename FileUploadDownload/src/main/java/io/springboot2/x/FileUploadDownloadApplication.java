package io.springboot2.x;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
//@EnableWebMvc
public class FileUploadDownloadApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUploadDownloadApplication.class, args);
	}
	
	  @Bean public CommonsMultipartResolver multipartResolver() {
		  return new
	  CommonsMultipartResolver(); }
	 

}
