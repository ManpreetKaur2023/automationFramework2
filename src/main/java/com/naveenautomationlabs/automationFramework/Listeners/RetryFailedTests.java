package com.naveenautomationlabs.automationFramework.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.naveenautomationlabs.automationFramework.base.TestBase;

public class RetryFailedTests extends TestBase implements IRetryAnalyzer {
	 private int maxCounter = 1;
	 private int cnt = 0;

	@Override
	public boolean retry(ITestResult result) {
		logger.info("Retrying failed test !!!!!!! " + result.getMethod().getMethodName() + " for " + cnt + " times");
		if (cnt < maxCounter) {
			cnt++;
			return true;

		}
		return false;
	}

}
