package com.naveenautomationlabs.automationFramework.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.naveenautomationlabs.automationFramework.Listeners.WebDriverEvents;
import com.naveenautomationlabs.automationFramework.Utils.Browsers;
import com.naveenautomationlabs.automationFramework.Utils.Environments;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver wd;
	private FileInputStream fileInputStream;
	private Properties prop;
	public static Logger logger;
	private WebDriverEventListener events;
	private EventFiringWebDriver eDriver;
	public static WebDriverWait wait;

	private Browsers browserName = Browsers.CHROME;
	private Environments environment=Environments.Prod;

	public TestBase() {
		prop = new Properties();
		try {
			fileInputStream = new FileInputStream(
					"C:\\Users\\Gurwinder\\eclipse-workspace\\automationFramework\\src\\main\\java\\com\\naveenautomationlabs\\automationFramework\\config\\Config.properties");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			prop.load(fileInputStream);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@BeforeClass
	public void setUpLogger() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator
				.configure("C:\\Users\\Gurwinder\\eclipse-workspace\\automationFramework\\lod4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);
	}

	public void intialisation() {

		switch (browserName.getBrowserName()) {
		case "Chrome":
			wd = WebDriverManager.chromedriver().create();
 			break;
		case "Edge":
			wd = WebDriverManager.edgedriver().create();
			break;
		case "Firefox":
			wd = WebDriverManager.firefoxdriver().create();
			break;
		case "Safari":
			wd = WebDriverManager.firefoxdriver().create();
			break;
		default:
			System.out.println("Enter a valid browser name.");
			break;
		}

		eDriver = new EventFiringWebDriver(wd);
		events = new WebDriverEvents();
		eDriver.register(events);
		wd = eDriver;

		wd.get(environment.getUrl());
		// wd.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICIT_WAIT")),
		// TimeUnit.SECONDS);
		wait = new WebDriverWait(wd, 10);
		wd.manage().window().maximize();
	}

	public void tearDown() {
		wd.close();
	}

}
