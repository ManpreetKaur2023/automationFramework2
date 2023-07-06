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

public class MyAccountTest extends TestBase {
	private YourStore yourStore;
	private AccountLogin accountLogin;
	private MyAccount myAccount;

	@BeforeMethod
	public void setUp() {
		intialisation();
		yourStore = new YourStore();
	}

	@Test
	public void validateLoginUsingValidCredential() {
		yourStore.clickAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		myAccount = accountLogin.clickLoginBtn();
		Assert.assertEquals(myAccount.getMyAccountText(), "My Account", "You are on wrong page");

	}

	@Test
	public void validateSideNavigationBar() {
		yourStore.clickAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		myAccount = accountLogin.clickLoginBtn();
		Assert.assertTrue(myAccount.selectOptionFromSideNavigationBar("Edit Account"),
				"navigation option  is not clicked");
	}

	@Test(dataProvider = "LoginDataProvider")
	public void loginTest(String username, String password) throws IOException {
		yourStore.clickAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		accountLogin.enterEmail(username);
		accountLogin.enterPassword(password);
		myAccount = accountLogin.clickLoginBtnForExcel();
		System.out.println(wd.getTitle());
	}

	@DataProvider(name = "LoginDataProvider")
	public String[][] getDataFromExcelSheet() throws IOException {
		logger.info("data provider gets executed");
		String filePath = "C:\\Users\\Gurwinder\\eclipse-workspace\\automationFramework\\data.xlsx";
		int rowCnt = ExcelUtils.getRowCount(filePath, "Sheet1");
		int colCnt = ExcelUtils.getCellCount(filePath, "Sheet1", rowCnt);

		String[][] virtualSheet = new String[rowCnt][colCnt];

		for (int i = 1; i <= rowCnt; i++) {
			for (int j = 0; j < colCnt; j++) {
				virtualSheet[i - 1][j] = ExcelUtils.getCelldata(filePath, "Sheet1", i, j);
			}
		}

		return virtualSheet;
	}

	@AfterMethod
	public void quit() {
		tearDown();
	}

}
