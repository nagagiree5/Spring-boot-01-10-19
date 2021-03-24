package io.springboot2.x;

import java.security.Principal;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class Oauth2FacebookApplication {

	
	
    @GetMapping({"/user","/"})
    public String welcome(Principal principal) {
        Map<String, Object> details = (Map<String, Object>)
                ((OAuth2Authentication) principal).getUserAuthentication().getDetails();
        String userName = (String) details.get("name");
        return "Hi " + userName + " Welcome to Oauth2Application !!";
    }
	
	
	public static void main(String[] args) {
		SpringApplication.run(Oauth2FacebookApplication.class, args);
	}

}
