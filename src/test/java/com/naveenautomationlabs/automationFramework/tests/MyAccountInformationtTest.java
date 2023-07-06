package com.naveenautomationlabs.automationFramework.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.automationFramework.base.TestBase;
import com.naveenautomationlabs.automationFramework.pages.AccountLogin;
import com.naveenautomationlabs.automationFramework.pages.MyAccount;
import com.naveenautomationlabs.automationFramework.pages.MyAccountInformation;
import com.naveenautomationlabs.automationFramework.pages.OrderHistory;
import com.naveenautomationlabs.automationFramework.pages.YourStore;

public class MyAccountInformationtTest extends TestBase {

	@BeforeMethod
	public void setUp() {
		intialisation();

	}

	@AfterMethod
	public void quit() {
		tearDown();
	}

}
