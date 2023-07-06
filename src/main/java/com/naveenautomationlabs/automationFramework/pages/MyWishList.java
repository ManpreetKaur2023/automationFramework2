package com.naveenautomationlabs.automationFramework.pages;

import com.naveenautomationlabs.automationFramework.base.TestBase;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyWishList extends TestBase{
	
	
	
	
	//in method model is a unique key that wht passing as an argument
	public WebElement getCellElementFromTable(myWishListTable column ,String model) {
		
		int columnIndex=getInDExOfColumn(column);
		if(columnIndex<0) {
			throw new NoSuchElementException();
		}
		
		List<WebElement> rowWebElement=wd.findElements(By.cssSelector("div.table-responsive table tbody tr"));
	for (int i = 0; i < rowWebElement.size(); i++) {
		List<WebElement> cell=rowWebElement.get(i).findElements(By.cssSelector("td"));
		if((cell.get(2)).getText().equals(model)){ //2 is written because this is unique
			return cell.get(columnIndex);
		}
	}
		
		
		return null;
		
	}
	
	
	
	
	
	
	
	
	private int getInDExOfColumn(myWishListTable columnName) {//myWishListtable is passed in argument so that it will accept values from enum only
		List<WebElement> headers=wd.findElements(By.cssSelector("table.table  thead tr td"));
		for (WebElement headerElement : headers) {
			if(headerElement.getText().equals(columnName.value)){
				return headers.indexOf(headerElement);
			}
			
		}
		return -1;
		}
	
	
	
	
	
	public enum myWishListTable {

		IMAGE("Image"),
		PRODUCT_NAME("Product Name"),
		MODEL("Model"),
		STOCK("Stock"),
		UNIT_PRICE("Stock"),
		ACTION("Action");
		
		
		String value;

		private myWishListTable(String value) {
			this.value = value;

		}

		public String getTableHeaderValue() {
			return value;
		}

	}
}
