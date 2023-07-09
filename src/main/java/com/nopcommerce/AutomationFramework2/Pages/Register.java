package com.nopcommerce.AutomationFramework2.Pages;

import java.util.UUID;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.nopcommerce.AutomationFramework2.Base.TestBase;

public class Register extends TestBase {

	Register() {
		PageFactory.initElements(wd, this);
	}

	@BeforeMethod
	public void setUp() {
		intialisation();
	}
	

	public static String randomEmail = UUID.randomUUID().toString() + "@email.com"; // To generate unique random emailId.
	public static  String randomPassword = UUID.randomUUID().toString().substring(0, 8); // To generate unique random password.
	

	@FindBy(css = "#gender-female")
	private WebElement genderRadioBtnFemale;

	@FindBy(css = "#FirstName")
	private WebElement firstNameField;

	@FindBy(css = "#LastName")
	private WebElement lastnameField;
	
	@FindBy(css = "select[name='DateOfBirthDay']")
	private WebElement dateOfBirthDay;
	
	@FindBy(css = "select[name='DateOfBirthMonth']")
	private WebElement dateOfBirthMonth;
	
	@FindBy(css = "select[name='DateOfBirthYear']")
	private WebElement dateOfBirthYear;
	
	

	@FindBy(css = "#Email")
	private WebElement emailField;

	@FindBy(css = "#Company")
	private WebElement companynameField;

	@FindBy(xpath = "(//input[@name='Newsletter'])[1]")
	private WebElement newsletterCheckBox;

	@FindBy(css = "#Password")
	private WebElement passweodField;

	@FindBy(css = "#ConfirmPassword")
	private WebElement confirmPasswordField;

	@FindBy(id = "register-button")
	private WebElement registerBtn;

	@FindBy(xpath = "//div[text()='Your registration completed']")
	private WebElement registerBtnText;

	public void selectGender() {
		genderRadioBtnFemale.isSelected();
	}

	public void enterFirstName() {
		firstNameField.sendKeys("Manpreet");
	}

	public void enterLastName() {
		lastnameField.sendKeys("kaur");
	}
	
	public void selectDateOfBirthDay() {
		Select sc=new Select(dateOfBirthDay);
		sc.selectByValue("14");
		}
		
	
	public void selectDateOfBirthMonth() {
		Select sc=new Select(dateOfBirthMonth);
		sc.selectByValue("3");
		}
		
	
	public void selectDateOfBirthYear() {
		Select sc=new Select(dateOfBirthYear);
		sc.selectByValue("1914");
		}
		

	public void enterEmail() {
		emailField.sendKeys(randomEmail);
	}

	public void enterCompanyName() {
		companynameField.sendKeys("Pivot");
	}

	public void selectNewsletterCheckBox() {
		newsletterCheckBox.isSelected();
	}

	public void enterPassword() {
		passweodField.sendKeys(randomPassword);
	}

	public void enterConfirmPasswordField() {
		confirmPasswordField.sendKeys(randomPassword);
	}

	public Register clickRegisterBtn() {
		registerBtn.submit();
		return new Register();
	}

	public Register enterDetails() {
		selectGender();
		enterFirstName();
		enterLastName();
		selectDateOfBirthDay();
		selectDateOfBirthMonth();
		selectDateOfBirthYear();
		enterEmail();
		enterCompanyName();
		selectNewsletterCheckBox();
		enterPassword();
		enterConfirmPasswordField();
		return clickRegisterBtn();
	}

	public String getRegisterBtnText() {
		return registerBtnText.getText();

	}

	@AfterMethod
	public void quit() {
		tearDown();
	}
}
