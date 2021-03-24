package com.mvnrepo.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class SpringSecurityPwdEncrypted {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insertDetails(String username, String password, int enabled) {
		// TODO Auto-generated method stub
		
	BCryptPasswordEncoder pwdEncoder=new BCryptPasswordEncoder();
	String passwordIsEncoded=pwdEncoder.encode(password);
	
	
		int i2=jdbcTemplate.update("INSERT INTO USERTEST VALUES (?,?,?)", username,passwordIsEncoded,enabled);
		return i2;
	
	}
}  
