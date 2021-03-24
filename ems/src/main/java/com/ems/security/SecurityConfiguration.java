package com.ems.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)   //It  enables method-level  security
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	BCryptPasswordEncoder   encoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/delete**").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		/*
		 * httpBasic():  configures  HTTP Basic Authentication
		 * formLogin(): configures  HTTP Form  Authentication
		 */
		//.httpBasic()
		.formLogin() 
		/*
		 * formLogin()  provides a default login page to accept the credentials. If authentication fails then it provides
		 * default login page with error message.
		 * To customize the default login page, use this configuration
		 * loginPage() : To specify  url  to send users if login is required
		 * loginProcessingUrl(): To specify a url used in form action, to validate the credentials
		 * failureUrl():  To specify a url to redirect user, if login fails
		 */
		/*.loginPage("/login").loginProcessingUrl("/doLogin").failureUrl("/login?error=Bad Credentials") */
		.and()
		/*
		 * customize  access denined
		 */
		.exceptionHandling().accessDeniedPage("/WEB-INF/views/accessDenied.jsp")
		.and()
		.csrf().disable();
		
		//Restrict  the number of sessions of an authenticated user to one
		http.sessionManagement().maximumSessions(1);
		
		/*
		 * logout() :  invalidates user session
		 * logoutUrl() :  represents  an application url to initiate logout
		 * logoutSuccessUrl(): represents an application url to whom request is redirected on successful logout
		 */
		http.logout().logoutUrl("/logoutMe").logoutSuccessUrl("/loggedOut").permitAll();
		
		/*
		 * enable  https channel
		 */
		http.requiresChannel().anyRequest().requiresSecure();
	}
	
	
	@Autowired
	public   void   configureGlobal(AuthenticationManagerBuilder  builder)  throws  Exception {
		//Building  AuthenticationManager  with  in-memory authentication details
		/*
		builder.inMemoryAuthentication()
		.withUser("sathya").password(encoder.encode("123456")).roles("ADMIN")
		.and()
		.withUser("allen").password(encoder.encode("allen123")).roles("ACCOUNTANT");
		*/
		
		//Building AuthenticationManager with  Database Authentication details
		builder.jdbcAuthentication()
		.dataSource(ds())
		.usersByUsernameQuery("select username, password, enabled from users where username=?")
		.authoritiesByUsernameQuery("select username, authority  from authorities where username=?")
		.passwordEncoder(encoder);
				
	}
	
	
	public   DataSource     ds() {
		DriverManagerDataSource   ds =new  DriverManagerDataSource();
    	ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
    	ds.setUrl("jdbc:mysql://localhost:3306/security");
    	ds.setUsername("root");
    	ds.setPassword("giridb");
    	return ds;
	}
	
	@Bean
	public   BCryptPasswordEncoder    encoder() {
		return   new  BCryptPasswordEncoder();
	}

}
