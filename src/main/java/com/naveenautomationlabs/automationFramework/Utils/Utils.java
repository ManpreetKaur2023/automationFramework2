package com.naveenautomationlabs.automationFramework.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.naveenautomationlabs.automationFramework.base.TestBase;



public class Utils extends TestBase {
	
	public static void takeScreenshot(String testName) {
		String timeStaamp=new SimpleDateFormat("dd.MM.yyyy HH.mm.ss").format(new Date());
		 
		File screenshotFile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile, new File("./FailedTestsScreenshots/"+ timeStaamp +" "+".jpg"));;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	
	public static int getNumericValueFromString(String enteredValue) {
		
		String numericValue = enteredValue.replaceAll("\\D", "");
		int integerValue = Integer.parseInt(numericValue);
		return integerValue;
		
	}
	}


