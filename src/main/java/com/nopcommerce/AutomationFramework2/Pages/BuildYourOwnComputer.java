package com.nopcommerce.AutomationFramework2.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.nopcommerce.AutomationFramework2.Base.TestBase;

public class BuildYourOwnComputer extends TestBase {

	public BuildYourOwnComputer() {
		PageFactory.initElements(wd, this);
	}

	@BeforeMethod
	public void setUp() {
		intialisation();
	}

	@FindBy(xpath = "//select[@name='product_attribute_1']")
	private WebElement processor;

	@FindBy(xpath = "//select[@name='product_attribute_2']")
	private WebElement ram;

	@FindBy(css = "#product_attribute_input_3 li:nth-of-type(2) input")
	private WebElement hddRadioBtn;

	@FindBy(xpath = "(//input[@name='product_attribute_4'])[1]")
	private WebElement osRadioBtn;

	@FindBy(xpath = "(//input[@name='product_attribute_5'])[2]")
	private WebElement softwareCheckBox;

	@FindBy(css = "div.add-to-cart-panel button")
	private WebElement addToCartBtn;

	@FindBy(css = "div.bar-notification  p")
	private WebElement addToCartText;

	@FindBy(xpath = "//a[text()='shopping cart']")
	private WebElement shoppingCartLink;

	public void selectProcessorValue() {
		selectFromDropDownMenu(processor, "2.2 GHz Intel Pentium Dual-Core E2200");
	}

	public void selectRamValue() {
		selectFromDropDownMenu(ram, "4");

	}

	private void selectFromDropDownMenu(WebElement element, String text) {
		Select sc = new Select(element);
		try {
			sc.selectByVisibleText(text);
		} catch (Exception e) {
			sc.selectByValue(text);
		}
	}

	public void selectHddRadioBtn() {
		hddRadioBtn.click();
	}

	public void selectOsRadioBtn() {
		osRadioBtn.click();
	}

	public void selectSoftwareCheckBox() {
		softwareCheckBox.click();
	}

	public BuildYourOwnComputer selectSpecifications() {
		selectProcessorValue();
		selectRamValue();
		selectHddRadioBtn();
		selectOsRadioBtn();
		selectSoftwareCheckBox();
		return clickAddTocartBtn();

	}

	public BuildYourOwnComputer clickAddTocartBtn() {
		addToCartBtn.click();
		return new BuildYourOwnComputer();
	}

	public ShoppingCart clickShopingcartLink() {
		shoppingCartLink.click();
		return new ShoppingCart();

	}

	@AfterMethod
	public void quit() {
		tearDown();
	}

}
