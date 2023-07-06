package com.naveenautomationlabs.automationFramework.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.automationFramework.base.TestBase;
import com.naveenautomationlabs.automationFramework.pages.SearchIphone;
import com.naveenautomationlabs.automationFramework.pages.YourStore;

public class SearchIphoneTest extends TestBase {
	YourStore yourStore;
	SearchIphone searchIphone;

	@BeforeMethod
	public void setUp() {
		intialisation();
		yourStore = new YourStore();

	}

	@Test

	public void validateSearchBar() {
		searchIphone = yourStore.sendInputIntoSearchField();
		Assert.assertEquals(searchIphone.getSearchIphoneTextMessage(), "Search - iphone", "You are on wrong page");

	}

	@AfterMethod
	public void quit() {
		tearDown();
	}

}
