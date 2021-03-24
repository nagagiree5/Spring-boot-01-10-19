package com.mvnrepo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages="com.mvnrepo")
@PropertySource("classpath:movies.properties")
public class ApplicationConfig {

}
