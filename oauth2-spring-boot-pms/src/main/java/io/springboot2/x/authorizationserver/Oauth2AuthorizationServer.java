package io.springboot2.x.authorizationserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
@Configuration
@EnableAuthorizationServer                   // oauth/token
public class Oauth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override                                            // oauth/authorize
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		// TODO Auto-generated method stub
		security
		   .tokenKeyAccess("permitAll()")              // oauth/token_key
		   .checkTokenAccess("isAuthenticated()")      // oauth/check_token 
		   .allowFormAuthenticationForClients();
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// TODO Auto-generated method stub
		clients
		   .inMemory()
		   .withClient("clientapp").secret(passwordEncoder.encode("123456"))
		   .authorizedGrantTypes("password","authorization_code","refresh_token")
		   .authorities("READ_ONLY_CLIENT")
		   .scopes("read","write")
		   .resourceIds("oauth2-resource")
		   .redirectUris("http://localhost:8081/login")  //5353
		   .accessTokenValiditySeconds(43199)
		   .refreshTokenValiditySeconds(43199);
	}
}