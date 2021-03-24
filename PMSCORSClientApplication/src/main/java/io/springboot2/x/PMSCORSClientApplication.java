package io.springboot2.x;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class PMSCORSClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PMSCORSClientApplication.class, args);
	}

	@GetMapping({ "/", "/index" })
	private String getIndex() {
		return "index";
	}

}
