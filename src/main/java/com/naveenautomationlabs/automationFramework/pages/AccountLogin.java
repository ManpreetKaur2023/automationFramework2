package com.naveenautomationlabs.automationFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.naveenautomationlabs.automationFramework.base.TestBase;

public class AccountLogin extends TestBase {

	public AccountLogin() {
		PageFactory.initElements(wd, this);
	}

	@BeforeMethod
	public void setUp() {
		intialisation();
	}

	@FindBy(css = "#input-email")
	private WebElement emailField;

	@FindBy(css = "#input-password")
	private WebElement passwordField;

	@FindBy(css = "input[value='Login']")
	private WebElement loginBtn;

	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public MyAccount clickLoginBtnForExcel() {

//		enterEmail();
//		enterPassword();
		loginBtn.click();
		return new MyAccount();
	}

	public MyAccount clickLoginBtn() {

//		enterEmail();
//		enterPassword();
		loginBtn.click();
		return new MyAccount();
	}

	@AfterMethod
	public void quit() {
		tearDown();
	}
}
