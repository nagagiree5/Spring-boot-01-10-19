package io.springboot.junit.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestUser_Profile1.class,TestUser_Profile2.class})
public class TestSuite {

}
