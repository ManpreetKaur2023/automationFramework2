package com.naveenautomationlabs.automationFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.automationFramework.base.TestBase;

public class AccountHasBeenCreated  extends TestBase{
	
	public AccountHasBeenCreated() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#content h1")
	private WebElement accountHasBeenCreatedTextMessage;
	
	public String getAccounyHasbeenCreatedTextMessage() {
		return accountHasBeenCreatedTextMessage.getText();
		
	}

	
}
