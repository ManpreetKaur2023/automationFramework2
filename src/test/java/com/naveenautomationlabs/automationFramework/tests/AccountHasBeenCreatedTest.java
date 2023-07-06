package com.naveenautomationlabs.automationFramework.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.automationFramework.base.TestBase;
import com.naveenautomationlabs.automationFramework.pages.AccountHasBeenCreated;
import com.naveenautomationlabs.automationFramework.pages.RegisterAccount;
import com.naveenautomationlabs.automationFramework.pages.YourStore;

public class AccountHasBeenCreatedTest extends TestBase {
	
	private YourStore yourStore;
	private RegisterAccount registerAccount;
	AccountHasBeenCreated accountHasBeenCreated;


	@BeforeMethod
	public void setUp() {
		intialisation();
		yourStore=new YourStore();
	}
	
	@Test
	public void validateUserRegisterWithValidDetails() {
		yourStore.clickAccountBtn();
		registerAccount=yourStore.clickRegisterBtn();
		accountHasBeenCreated=registerAccount.enterValidDetailsToRegisterUser();
		
		Assert.assertEquals(accountHasBeenCreated.getAccounyHasbeenCreatedTextMessage(), "Your Account Has Been Created!","Unable to create account");
	}
	
	
	
	
	
	
	@AfterMethod
	public void quit() {
		tearDown();
	}
	
	
	

}
