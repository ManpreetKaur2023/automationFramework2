package com.naveenautomationlabs.automationFramework.Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.naveenautomationlabs.automationFramework.Utils.Utils;
import com.naveenautomationlabs.automationFramework.base.TestBase;

public class CustomListeners extends TestBase  implements ITestListener {
	@Override
	public  void onTestStart(ITestResult result) {
		logger.info("Test execution started for "+result.getMethod().getMethodName()+" ************************** ");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test "+result.getMethod().getMethodName() + " Passed ");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("Test  "+result.getMethod().getMethodName() + " Failed "+ " !!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ");
		Utils.takeScreenshot(result.getMethod().getMethodName());
	}
@Override
	public void onTestSkipped(ITestResult result) {
	logger.info("Test  "+result.getMethod().getMethodName() + " Skipped "+" ###############################");
		
	}

}
