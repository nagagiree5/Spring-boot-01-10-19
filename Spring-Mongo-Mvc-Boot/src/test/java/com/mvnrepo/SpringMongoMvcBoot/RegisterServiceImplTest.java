package com.mvnrepo.SpringMongoMvcBoot;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mvnrepo.entity.Gender;
import com.mvnrepo.repo.RegisterMongoRepository;
import com.mvnrepo.serviceimpl.RegisterServiceImpl;

class RegisterServiceImplTest {
	
	@Autowired
	RegisterMongoRepository repository;
	
	@Autowired
	RegisterServiceImpl impl1;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
//		fail("Not yet implemented");
		
		RegisterServiceImpl impl = new RegisterServiceImpl();
//		impl.setRepository(repository);
		
//		mock
		
		boolean actual = impl.registerEmployee("henna", "kkd.com", 3, Gender.MALE, new Date());
		assertTrue(actual == true);
		assertEquals(true, actual);
	}

}
