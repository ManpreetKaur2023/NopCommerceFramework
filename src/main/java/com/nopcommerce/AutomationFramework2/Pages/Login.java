package com.nopcommerce.AutomationFramework2.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.nopcommerce.AutomationFramework2.Base.TestBase;

public class Login extends TestBase {

	

	public Login() {
		PageFactory.initElements(wd, this);
	}

	@BeforeMethod
	public void setUp() {
		intialisation();
	}

	@FindBy(css = "#Email")
	private WebElement emailField;

	@FindBy(css = "#Password")
	private WebElement passwordField;

	@FindBy(css = "button.login-button")
	private WebElement loginBtn;

	public void enterEmail() {
		emailField.sendKeys(Register.randomEmail);
	}

	public void enterPassword() {
		passwordField.sendKeys(Register.randomPassword);
	}

	public void enterLoginDetails() {
		enterEmail();
		enterPassword();
	}

	public ShoppingCart clickLoginBtn() {
		loginBtn.submit();
		return new ShoppingCart();
	}

	public DemoStore clickLoginBtnForvalidateLogin() {
		loginBtn.submit();
		return new DemoStore();
	}

	@AfterMethod
	public void quit() {
		tearDown();
	}

}
