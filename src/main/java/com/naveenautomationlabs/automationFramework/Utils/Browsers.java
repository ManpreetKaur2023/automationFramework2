package com.naveenautomationlabs.automationFramework.Utils;

public enum Browsers {
	
	CHROME("Chrome"),
	EDGE("Edge"),
	FIREFOX("Firefox"),
	SAFARI("safari");
	
	
	String browserName;
	
	   Browsers(String nameOfBrowser) {
		browserName=nameOfBrowser;
		
	}
	
	
	
	public String getBrowserName() {
		return browserName;
	}
	
	
	

	
	
	

}
