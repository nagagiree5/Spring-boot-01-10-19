package com.ems.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		/*
		 * String pwd1 = encoder.encode("giridhar"); String pwd2 =
		 * encoder.encode("kesava");
		 * 
		 * jdbcTemplate.update("insert  into  users  values(?,?,?)", "giridhar", pwd1,
		 * 0); jdbcTemplate.update("insert  into  users  values(?,?,?)", "kesava", pwd2,
		 * 1);
		 * 
		 * jdbcTemplate.update("insert  into  authorities  values(?, ?) ", "giridhar",
		 * "ROLE_ADMIN");
		 * jdbcTemplate.update("insert  into  authorities  values(?, ?) ", "kesava",
		 * "ROLE_ACCOUNTANT");
		 * 
		 * String pwd3 = encoder.encode("pallavi");
		 * jdbcTemplate.update("insert  into  users  values(?,?,?)", "pallavi", pwd3,
		 * 1); jdbcTemplate.update("insert  into  authorities  values(?, ?) ",
		 * "pallavi", "ROLE_ACCOUNTANT");
		 */

	}

}
