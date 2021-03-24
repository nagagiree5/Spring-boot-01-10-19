package io.springboot.junit.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import io.springboot.junit.reg.CustomerService;
import io.springboot.junit.reg.RegistrationDto;
import io.springboot.junit.reg.NextGenBankException;

public class TestCustomerService {
	static  CustomerService  service;
	RegistrationDto   dto;
	@BeforeClass
	public  static  void  setUpBeforeClass() {
		service=new  CustomerService();
	}
	
	@Before
	public    void    setUp() {
		dto=new  RegistrationDto();
	}
	
	@After
	public  void  tearDown() {
		dto=null;
	}

	@Test
	public void testRegisterCustomerValid() {
		
		dto.setFirstName("Giridhar");
		dto.setLastName("Brion");
		dto.setEmailId("giridhar@yahoo.com");
		dto.setAadharId(5778990123L);
		dto.setPanNo("BXP3218F");
	
		assertTrue(service.registerCustomer(dto));
	}
	
	@Test(expected=NextGenBankException.class)
	public void testRegisterCustomerInValid() {
		
		dto.setFirstName("Alex");
		dto.setLastName("Winsky");
		dto.setEmailId("poojahegde@yahoo.com");
		dto.setAadharId(3778990555L);
		dto.setPanNo("BXP3218Z");
		
		assertFalse(service.registerCustomer(dto));
	}
	
	
	@AfterClass
	public  static  void  tearDownAfterClass() {
		service=null;
	}
	
	
}
