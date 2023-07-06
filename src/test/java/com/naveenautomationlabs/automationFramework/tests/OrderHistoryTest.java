package com.naveenautomationlabs.automationFramework.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.naveenautomationlabs.automationFramework.base.TestBase;

public class OrderHistoryTest extends TestBase {

	@BeforeMethod
	public void setUp() {
		intialisation();

	}

	@AfterMethod
	public void quit() {
		tearDown();
	}

}
