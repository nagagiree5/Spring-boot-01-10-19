package io.springboot.junit.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.model.TestTimedOutException;

import io.springboot.junit.User_Profile;

public class TestUser_Profile1 {

	private static User_Profile profile;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		profile = new User_Profile();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		profile = null;

	}

	@Test
	public void testIdSuggetions() {

		assertEquals("GIRIDHAR", profile.userIdSuggestion("giri", "dhar"));
	}

}
