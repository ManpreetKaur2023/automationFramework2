package com.naveenautomationlabs.automationFramework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.naveenautomationlabs.automationFramework.base.TestBase;

public class MyAccount extends TestBase {

	public MyAccount() {
		PageFactory.initElements(wd, this);
	}

	@BeforeMethod
	public void setUp() {
		intialisation();
	}

	@FindBy(css = "#content h2")
	private WebElement myAccountText;

	@FindBy(css = "#div.collapse  ul.nav >li:nth-of-type(3)")
	private WebElement componentBtn;

	@FindBy(css = "div.collapse  ul.nav >li:nth-of-type(3) ul.list-unstyled li:nth-of-type(2)")
	private WebElement monitorsBtn;

	@FindBy(css = "div.list-group a")
	private List<WebElement> options;

	@FindBy(css = "div.list-group a:nth-of-type(2)")
	private WebElement editAccountBtn;
	
	
	@FindBy(css = "ul.list-inline li:nth-of-type(3) span")
	private WebElement wishListBtn;


	public String getMyAccountText() {
		return myAccountText.getText();

	}
	
	
	public MyWishList clickMyWishlistBtn() {
		wishListBtn.click();
		return new MyWishList();
	}


	public void clickComponentBtn() {
		componentBtn.click();
	}

	public void clickMonitorsBtn() {
		monitorsBtn.click();
	}

	public boolean selectOptionFromSideNavigationBar(String selectedOption) {

		for (WebElement option : options) {
			if (option.getText().contains(selectedOption)) {
				wait.until(ExpectedConditions.elementToBeClickable(option));
				option.click();
				return true;
			}
		}
		return false;
	}

	@AfterMethod
	public void quit() {
		tearDown();
	}

}
