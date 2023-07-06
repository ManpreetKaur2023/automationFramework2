package com.naveenautomationlabs.automationFramework.Utils;

public enum Environments {
	
	DEV("Dev","https://naveenautomationlabsdev.com/opencart/index.php?route=common/home"),
	STAGE("Stage","https://naveenautomationlabsstage.com/opencart/index.php?route=common/home"),
	QA("Qa","https://naveenautomationlabsqa.com/opencart/index.php?route=common/home"),
	Prod("Prod","https://naveenautomationlabs.com/opencart/index.php?route=common/home");
	
	String env;
	String url;
	

	private Environments(String env,String url) {
		this.env = env;
		this.url=url;
	}

	public String getEnv() {
		return env;
	}

	public String getUrl() {
		return url;
	}
	
	
	
	

}
