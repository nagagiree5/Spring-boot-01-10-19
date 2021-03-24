package com.mvnrepo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	PasswordEncoder encoder;
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	            .antMatchers("/getRegister").hasAnyRole("CEO", "ADMIN")
	            .antMatchers("/updateEmployee").hasAnyRole("CEO", "ADMIN","MANAGER")
	            .antMatchers("/deleteEmployee").hasAnyRole("CEO", "ADMIN","MANAGER")
	                .anyRequest().permitAll()
	              
	                .and()
	                .formLogin()
	               //  .httpBasic();
	               .loginPage("/login")
	               
	               .failureUrl("/login?error=true")  //Not only true in the place of true at any name like yes some other...
	                .and()
	                .csrf().disable(); 
	          http.sessionManagement().maximumSessions(1);
		/* csrf(cross side request forgery) is bydefault enable we can desable that....If .formLogin() is used... */
	    }

	
	
	@Autowired
      protected void configureAuthentication(AuthenticationManagerBuilder auth)
      throws Exception {
		
		/*
		 * auth .inMemoryAuthentication()
		 * 
		 * .withUser("admin") .password(encoder.encode("admin")) .roles("ADMIN") .and()
		 * 
		 * .withUser("ceo") .password(encoder.encode("ceo")) .roles("CEO") .and()
		 * 
		 * .withUser("manager") .password(encoder.encode("manager")) .roles("MANAGER");
		 */
		auth.jdbcAuthentication().dataSource(dataSource())
        .usersByUsernameQuery("select username, password, enabled"   //giridb.
            + " from users where username=?")
        .authoritiesByUsernameQuery("select username, authority "
            + "from authorities where username=?")
        .passwordEncoder(encoder);
         
   }
    
    @Bean
    public  DataSource   dataSource() {
		/*
		 * DriverManagerDataSource ds =new DriverManagerDataSource();
		 * ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		 * ds.setUrl("jdbc:mysql://localhost:3306/giridb"); ds.setUsername("root");
		 * ds.setPassword("giridb"); return ds;
		 */
    	
    	DriverManagerDataSource   ds =new  DriverManagerDataSource();
    	ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
    	ds.setUrl("jdbc:oracle:thin:@localhost:1521/xe");
    	ds.setUsername("giridb");
    	ds.setPassword("giridb");
    	return ds;
    }
    
        
  

	 
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		
		return new BCryptPasswordEncoder() ;
		
	}
	
	
}
