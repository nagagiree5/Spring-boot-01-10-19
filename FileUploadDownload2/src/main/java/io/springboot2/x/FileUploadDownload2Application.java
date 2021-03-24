package io.springboot2.x;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class FileUploadDownload2Application {

	public static void main(String[] args) {
		SpringApplication.run(FileUploadDownload2Application.class, args);
	}
	
	  @Bean public CommonsMultipartResolver multipartResolver() {
		  return new
	  CommonsMultipartResolver(); }
}
