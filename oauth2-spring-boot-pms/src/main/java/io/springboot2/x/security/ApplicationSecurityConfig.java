package io.springboot2.x.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Order(1)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		  .antMatcher("/**")
		  .authorizeRequests()
		  .antMatchers("/oauth/authorize**","/login**","/error**")
		  
		  .permitAll()
	.and()
		  .authorizeRequests()
		  .anyRequest().authenticated()
    .and()  
          .formLogin().permitAll();
		
		/*
		 * .and() .csrf() .disable();
		 */
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth
		  .inMemoryAuthentication()
		  .withUser("giridhar").password(passwordEncoder().encode("9492011")).roles("USER");
		
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder() ;
		
	}
}
  