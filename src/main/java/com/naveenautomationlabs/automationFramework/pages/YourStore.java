package com.naveenautomationlabs.automationFramework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.naveenautomationlabs.automationFramework.Utils.Utils;
import com.naveenautomationlabs.automationFramework.base.TestBase;

public class YourStore extends TestBase {

	public YourStore() {
		PageFactory.initElements(wd, this);
	}

	@BeforeMethod
	public void setUp() {
		intialisation();

	}

	@FindBy(css = "ul.list-inline>li:nth-of-type(2) a")
	private WebElement myAccountBtn;

	@FindBy(css = "ul.dropdown-menu  li:nth-of-type(2) a")
	private WebElement loginBtn;

	@FindBy(css = "ul.list-inline li:nth-of-type(2) ul>li ")
	private WebElement registerBtn;

	@FindBy(css = "#wishlist-total  span")
	private WebElement wishListBtn;

	@FindBy(css = "div.alert i")
	private WebElement wishListBtnSuccessMessage;

	@FindBy(css = "#common-home div.col-sm-12 div.row>div:nth-of-type(1) div.button-group button:nth-of-type(2)")
	private WebElement addToWishlistOfMacBook;

	@FindBy(css = "#common-home div.col-sm-12 div.row>div:nth-of-type(2) div.button-group button:nth-of-type(2)")
	private WebElement addToWishlistOfIphone;

	@FindBy(css = "#search input")
	private WebElement searchInputField;

	@FindBy(css = "#search button")
	private WebElement searchBtn;

	@FindBy(css = "#logo")
	private WebElement logo;

	@FindBy(css = "div.slideshow")
	private WebElement displayMacBookOnMainPage;

	@FindBy(xpath = "//a[text()='iPhone'] ")
	private WebElement iPhoneBtnText;

	public YourStore clickAccountBtn() {
		myAccountBtn.click();
		return new YourStore();
	}

	public AccountLogin clickLoginBtn() {
		loginBtn.click();
		return new AccountLogin();
	}

	public RegisterAccount clickRegisterBtn() {
		registerBtn.click();
		return new RegisterAccount();
	}

	public boolean getUpdatedWishlistAfterAddingItem() {

		int currentWishlistValue = Utils.getNumericValueFromString(wishListBtn.getText());

		wait.until(ExpectedConditions.elementToBeClickable(addToWishlistOfIphone));
		addToWishlistOfIphone.click();
		wait.until(ExpectedConditions.elementToBeClickable(addToWishlistOfMacBook));
		addToWishlistOfMacBook.click();

		wait.until(ExpectedConditions.elementToBeClickable(wishListBtn));

		int updatedwishListvalue = Utils.getNumericValueFromString(wishListBtn.getText());
		if (!(updatedwishListvalue == currentWishlistValue)) {
			return true;
		}

		return false;
	}

	public SearchIphone sendInputIntoSearchField() {
		searchInputField.sendKeys("iphone");
		searchBtn.click();
		return new SearchIphone();
	}

	public boolean isLogoDisplayed() {
		return logo.isDisplayed();
	}

	public boolean selectItemFromText(String enteredText) {

		if (enteredText ==null) {
			throw new IllegalArgumentException("Entered text is null.");
		}
		
			List<WebElement> options = wd.findElements(By.cssSelector("#content>div.row>div h4"));
			for (WebElement option : options) {
				if (option.getText().contains(enteredText)) {

					wait.until(ExpectedConditions.elementToBeClickable(option));
					option.click();
					return true;

				}

			}
		 
		return false;
	}

	public boolean checkDisplayImageIsMoving() {

		int point1X = displayMacBookOnMainPage.getLocation().getX();
		int point1Y = displayMacBookOnMainPage.getLocation().getY();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// wait.until(ExpectedConditions.visibilityOf(displayMacBookOnMainPage));

		int point2X = displayMacBookOnMainPage.getLocation().getX();
		int point2Y = displayMacBookOnMainPage.getLocation().getY();
		if ((point1X == point2X) && (point1Y == point2Y)) {
			return true;
		} else {

			return false;
		}

	}

	@AfterMethod
	public void quit() {
		tearDown();
	}

}
