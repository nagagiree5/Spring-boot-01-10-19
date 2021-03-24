package io.springboot2.x;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PmsRestApplication implements WebMvcConfigurer  {

	public static void main(String[] args) {
		SpringApplication.run(PmsRestApplication.class, args);
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
		       //WebMvcConfigurer.super.addCorsMappings(registry);
	}
	
	@Bean 
	public Docket docket() {
		ApiInfo apiInfo=new ApiInfoBuilder().title("PMS REST APPLICATION DOCUMENTAION...")
				.description("PMS is one of the top running website where you can get all Products info. The data are uploaded in fast servers to serve you all the best of service possible...")
				.contact(new Contact("NagaGiree", null, "nagagirigollapalli5@gmail.com"))
				.license("Sathya license").licenseUrl("http://www.sathyatech.com").build();
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("io.springboot2.x.controller"))
				.paths(PathSelectors.any())
				.build().apiInfo(apiInfo);
	}
}
