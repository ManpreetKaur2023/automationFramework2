package com.naveenautomationlabs.automationFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.naveenautomationlabs.automationFramework.base.TestBase;

public class SearchIphone extends TestBase {
	public SearchIphone() {
		PageFactory.initElements(wd, this);
	}

	@BeforeMethod
	public void setUp() {
		intialisation();
	}

	@FindBy(css = "div.col-sm-12 h1")
	private WebElement SearchIphoneTextMessge;

	public String getSearchIphoneTextMessage() {
		return SearchIphoneTextMessge.getText();

	}

	@AfterMethod
	public void quit() {
		tearDown();
	}

}
