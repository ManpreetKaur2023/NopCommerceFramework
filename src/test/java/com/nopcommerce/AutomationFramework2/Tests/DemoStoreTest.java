package com.nopcommerce.AutomationFramework2.Tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.nopcommerce.AutomationFramework2.Base.TestBase;
import com.nopcommerce.AutomationFramework2.Pages.DemoStore;
import com.nopcommerce.AutomationFramework2.Pages.Login;
import com.nopcommerce.AutomationFramework2.Pages.Register;

public class DemoStoreTest extends TestBase {

	DemoStore demoStore;
	Register register;
	Login login;

	@BeforeMethod
	public void setUp() {
		intialisation();
		demoStore = new DemoStore();
	}

	@Test(priority = 1)
	
	public void validateUserRegister() {

		register = demoStore.clickRegisterBtn();
		register = register.enterDetails();
		Assert.assertEquals(register.getRegisterBtnText(), "Your registration completed", "Registeration Failed");

	}

	@Test(priority = 2)
	public void validateLoginWithPositiveCredential() {
		login = demoStore.clickLoginBtn();
		login.enterLoginDetails();
		demoStore = login.clickLoginBtnForvalidateLogin();
		Assert.assertEquals(demoStore.getWelcomeMessageAfterLogin(), "Welcome to our store", "You are on wrong page");
	}
	
	
	@Test
	
	public void validateWindowSwitch() {

    Assert.assertEquals(demoStore.switchToYouTube(), "https://www.youtube.com/user/nopCommerce","You are not on selected window");
	}


	@AfterMethod
	public void quit() {
		tearDown();
	}

}
