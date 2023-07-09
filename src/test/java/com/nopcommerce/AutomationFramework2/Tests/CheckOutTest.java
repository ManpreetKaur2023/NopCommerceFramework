package com.nopcommerce.AutomationFramework2.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nopcommerce.AutomationFramework2.Base.TestBase;
import com.nopcommerce.AutomationFramework2.Pages.BuildYourOwnComputer;
import com.nopcommerce.AutomationFramework2.Pages.CheckOut;
import com.nopcommerce.AutomationFramework2.Pages.DemoStore;
import com.nopcommerce.AutomationFramework2.Pages.Desktops;
import com.nopcommerce.AutomationFramework2.Pages.Login;
import com.nopcommerce.AutomationFramework2.Pages.Register;
import com.nopcommerce.AutomationFramework2.Pages.ShoppingCart;

public class CheckOutTest extends TestBase {

	DemoStore demoStore;
	Register register;
	Login login;
	CheckOut checkout;
	Desktops desktops;
	ShoppingCart shoppingCart;
	BuildYourOwnComputer buildYourOwnComputer;

	@BeforeMethod
	public void setUp() {
		intialisation();
		demoStore = new DemoStore();
	}

	@Test
	public void validatePlaceOrderCheckoutProcess() {

		register = demoStore.clickRegisterBtn();
		register = register.enterDetails();
		demoStore.selectComputerOption();
		desktops = demoStore.clickDesktopsBtn();
		buildYourOwnComputer = desktops.clickAddToCartBtn();
		buildYourOwnComputer = buildYourOwnComputer.selectSpecifications();
		shoppingCart = buildYourOwnComputer.clickShopingcartLink();
		shoppingCart.clickTermsOfServiceCheckBox();
		login = shoppingCart.clickCheckOutBtn();
		login.enterLoginDetails();
		shoppingCart = login.clickLoginBtn();
		shoppingCart.clickTermsOfServiceCheckBox();
		checkout = shoppingCart.clickCheckOutBtnForFinalCheckout();
		checkout.enterAddressDetails();
		checkout = checkout.selectContinueBtn();

		checkout.selectShippingMethodRadioBtn();
		checkout = checkout.selectContinueBtnAfterShippingMethod();

		checkout.selectPaymentMethodRadioBtn();
		checkout = checkout.selectContinueBtnAfterpaymentMethod();

		checkout = checkout.selectContinueBtnAfterpaymentInformation();

		checkout = checkout.selectConfirmBtn();
		Assert.assertEquals(checkout.showOrderSucessTextMessage(), "Your order has been successfully processed!",
				"Checkout failed");

	}
	@AfterMethod
	public void quit() {
		tearDown();
	}

}
