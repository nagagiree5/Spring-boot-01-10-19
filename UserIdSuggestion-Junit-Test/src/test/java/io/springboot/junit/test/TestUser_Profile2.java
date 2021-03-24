package io.springboot.junit.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import io.springboot.junit.User_Profile;

public class TestUser_Profile2 {

	private static User_Profile profile;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		profile = new User_Profile();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		profile = null;

	}

	@Test(timeout = 4000)
	public void testTakingIdUser() {

		List<String> listOfIds = new ArrayList<String>();
		listOfIds.add("GIRIDHAR");
		listOfIds.add("GIRIDHAR1");
		listOfIds.add("GIRIDHAR2");

		String suggestion = "GIRIDHAR";
		assertEquals("GIRIDHAR3", profile.takingIdUser(listOfIds, suggestion));

	}
}
