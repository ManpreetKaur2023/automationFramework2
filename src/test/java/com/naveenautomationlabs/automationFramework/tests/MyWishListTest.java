package com.naveenautomationlabs.automationFramework.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.automationFramework.base.TestBase;
import com.naveenautomationlabs.automationFramework.pages.AccountLogin;
import com.naveenautomationlabs.automationFramework.pages.MyAccount;
import com.naveenautomationlabs.automationFramework.pages.MyWishList;
import com.naveenautomationlabs.automationFramework.pages.MyWishList.myWishListTable;
import com.naveenautomationlabs.automationFramework.pages.YourStore;

public class MyWishListTest extends TestBase {
	
	private YourStore yourStore;
	private AccountLogin accountLogin;
	private MyAccount myAccount;
	MyWishList mywishList;

	
	
	
	@BeforeMethod
	public void setUp() {
		intialisation();
		yourStore = new YourStore();

	}
	
	@Test
	public void test() {
		yourStore.clickAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		myAccount = accountLogin.clickLoginBtn();
		mywishList=myAccount.clickMyWishlistBtn();
		//int index=mywishList.getInDExOfColumn(myWishListTable.MODEL);
		//.System.out.println(index);
		
		WebElement element=mywishList.getCellElementFromTable(myWishListTable.PRODUCT_NAME, "Product 15");
		System.out.println(element.getText());
	}
	
	
	
	

	@AfterMethod
	public void quit() {
		tearDown();
	}
}
