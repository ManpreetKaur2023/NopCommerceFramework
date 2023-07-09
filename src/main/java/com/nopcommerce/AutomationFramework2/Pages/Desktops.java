package com.nopcommerce.AutomationFramework2.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.nopcommerce.AutomationFramework2.Base.TestBase;

public class Desktops extends TestBase {
	public Desktops() {
	PageFactory.initElements(wd, this);
	}

	@BeforeMethod
	public void setUp() {
		intialisation();
	}
	
	
	@FindBy(xpath = "(//button[text()='Add to cart'])[1]")
	private WebElement addTOCartBtn;
	
	
	public BuildYourOwnComputer clickAddToCartBtn() {
		addTOCartBtn.click();
		return new BuildYourOwnComputer();
		
	}
	
	
	@AfterMethod
	public void quit() {
		tearDown();
	}

}
