package com.naveenautomationlabs.automationFramework.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.automationFramework.base.TestBase;
import com.naveenautomationlabs.automationFramework.pages.AccountHasBeenCreated;
import com.naveenautomationlabs.automationFramework.pages.RegisterAccount;
import com.naveenautomationlabs.automationFramework.pages.YourStore;

public class RegisterAccountTest extends TestBase {

	private YourStore yourStore;
	private RegisterAccount registerAccount;
	AccountHasBeenCreated accountHasBeenCreated;

	@BeforeMethod
	public void setUp() {
		intialisation();
		yourStore = new YourStore();
	}

	@Test
	public void validateUserRegisterWithAlreadyRegisteredEmail() {
		yourStore.clickAccountBtn();
		registerAccount = yourStore.clickRegisterBtn();
		registerAccount = registerAccount.enterDetailsWithAlreadyRegisteredEmail();
		Assert.assertEquals(registerAccount.getEmailAlreadyEixtsMessage(),
				"Warning: E-Mail Address is already registered!");
	}

	@AfterMethod
	public void quit() {
		tearDown();
	}

}
