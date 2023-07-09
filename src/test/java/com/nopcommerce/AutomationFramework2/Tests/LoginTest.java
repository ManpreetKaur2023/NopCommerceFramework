package com.nopcommerce.AutomationFramework2.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.nopcommerce.AutomationFramework2.Base.TestBase;

public class LoginTest extends TestBase {
	
	@BeforeMethod
	public void setUp() {
		intialisation();
	}
	
	
	
	@AfterMethod
	public void quit() {
		tearDown();
	}

}
