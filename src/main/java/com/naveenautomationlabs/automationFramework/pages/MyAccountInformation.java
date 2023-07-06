package com.naveenautomationlabs.automationFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.naveenautomationlabs.automationFramework.base.TestBase;

public class MyAccountInformation extends TestBase {

	public MyAccountInformation() {
		PageFactory.initElements(wd, this);
	}

	@BeforeMethod
	public void setUp() {
		intialisation();
	}

	@FindBy(css = "div.col-sm-9 h1")
	private WebElement myAccountInformationTextMessge;

	public String getMyAccountInformationTextMessageText() {
		return myAccountInformationTextMessge.getText();

	}

	@AfterMethod
	public void quit() {
		tearDown();
	}

}
