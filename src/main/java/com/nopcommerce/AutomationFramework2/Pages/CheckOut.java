package com.nopcommerce.AutomationFramework2.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.nopcommerce.AutomationFramework2.Base.TestBase;

public class CheckOut extends TestBase {

	public CheckOut() {
		PageFactory.initElements(wd, this);
	}

	@BeforeMethod
	public void setUp() {
		intialisation();
	}

	
	@FindBy(css = "#BillingNewAddress_FirstName")
	private WebElement firstNameField;

	@FindBy(css = "#BillingNewAddress_LastName")
	private WebElement lastNameField;

	@FindBy(css = "#BillingNewAddress_Email")
	private WebElement emailField;

	@FindBy(css = "#BillingNewAddress_Company")
	private WebElement companyNameField;

	@FindBy(css = "#BillingNewAddress_CountryId")
	private WebElement country;

	@FindBy(css = "#BillingNewAddress_City")
	private WebElement cityField;

	@FindBy(css = "#BillingNewAddress_Address1")
	private WebElement address1Field;

	@FindBy(css = "#BillingNewAddress_Address2")
	private WebElement address2Field;

	@FindBy(css = "#BillingNewAddress_ZipPostalCode")
	private WebElement postalCodeField;

	@FindBy(css = "#BillingNewAddress_PhoneNumber")
	private WebElement phoneNumberField;

	@FindBy(css = "#BillingNewAddress_FaxNumber")
	private WebElement faxNumberField;

	@FindBy(css = "#billing-buttons-container button:nth-of-type(4)")
	private WebElement continueBtn;

	@FindBy(css = "#shippingoption_2")
	private WebElement shippingMethodRadioBtn;

	@FindBy(xpath = "(//button[text()='Continue'])[3]")
	private WebElement continueBtnAfterShippingMethod;

	@FindBy(css = "#paymentmethod_0")
	private WebElement paymentMethodRadioBtn;

	@FindBy(xpath = "(//button[text()='Continue'])[4]")
	private WebElement continueBtnAfterPaymentMethod;

	@FindBy(xpath = "(//button[text()='Continue'])[5]")
	private WebElement continueBtnAfterpaymentInformation;

	@FindBy(xpath = "(//button[text()='Confirm'])")
	private WebElement confirmBtn;

	@FindBy(xpath = "//strong[text()='Your order has been successfully processed!']")
	private WebElement orderSucessMessage;

	
	public void selectCountry() {
		Select sc = new Select(country);
		sc.selectByValue("168");
	}

	public void entercityField() {
		cityField.sendKeys("Toronto");
	}

	public void enterAddress1Field() {
		address1Field.sendKeys("Woodstock");
	}

	public void enterAddress2Field() {
		address2Field.sendKeys("Crescent");
	}

	public void enterPostalCodeField() {
		postalCodeField.sendKeys("N4V0B2");
	}

	public void enterPhoneNumber() {
		phoneNumberField.sendKeys("123456789");
	}

	public void enterFaxNumberField() {
		faxNumberField.sendKeys("098765");
	}

	public void enterAddressDetails() {
		
		selectCountry();
		entercityField();
		enterAddress1Field();
		enterAddress2Field();
		enterPostalCodeField();
		enterPhoneNumber();
		enterFaxNumberField();
		
	}

	public CheckOut selectContinueBtn() {
		continueBtn.click();
		return new CheckOut();
	}

	public void selectShippingMethodRadioBtn() {
		shippingMethodRadioBtn.click();
	}

	public CheckOut selectContinueBtnAfterShippingMethod() {
		continueBtnAfterShippingMethod.click();
		return new CheckOut();
	}

	public void selectPaymentMethodRadioBtn() {
		paymentMethodRadioBtn.click();
	}

	public CheckOut selectContinueBtnAfterpaymentMethod() {
		continueBtnAfterPaymentMethod.click();
		return new CheckOut();
	}

	public CheckOut selectContinueBtnAfterpaymentInformation() {
		continueBtnAfterpaymentInformation.click();
		return new CheckOut();
	}

	public CheckOut selectConfirmBtn() {
		confirmBtn.click();
		return new CheckOut();
	}

	public String showOrderSucessTextMessage() {
		return orderSucessMessage.getText();

	}

	@AfterMethod
	public void quit() {
		tearDown();
	}

}
