package com.naveenautomationlabs.automationFramework.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naveenautomationlabs.automationFramework.Utils.ExcelUtils;
import com.naveenautomationlabs.automationFramework.base.TestBase;
import com.naveenautomationlabs.automationFramework.pages.AccountLogin;
import com.naveenautomationlabs.automationFramework.pages.MyAccount;
import com.naveenautomationlabs.automationFramework.pages.YourStore;

public class YourStoreTest extends TestBase {

	private YourStore yourStore;
	private AccountLogin accountLogin;
	private MyAccount myAccount;

	@BeforeMethod
	public void setUp() {
		intialisation();

		yourStore = new YourStore();

	}

	@Test
	public void failedTestCaseExample() {
		Assert.assertEquals("Manpreet", "Kaur");
	}

	@Test
	public void validateItemsAddedToTheWishlist() {

		Assert.assertTrue(yourStore.getUpdatedWishlistAfterAddingItem(), "Wishlist is not updated");

	}

	@Test
	public void validateLogoIsDisplayed() {
		Assert.assertTrue(yourStore.isLogoDisplayed(), "Logo is not displayed");
	}

	@Test
	public void validateIsDisplayImageMoving() {
		Assert.assertTrue(yourStore.checkDisplayImageIsMoving(), "image is not moving");
	}

	@Test
	public void validateIsImageSelectedFromVisibleText() {

		Assert.assertTrue(yourStore.selectItemFromText(null), "Button is not clicked");
	}

	@AfterMethod
	public void quit() {
		tearDown();
	}
}
