package com.nopcommerce.AutomationFramework2.Base;

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
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.BeforeClass;

import com.nopcommerce.AutomationFramework.Listeners.WebDriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver wd;
	FileInputStream fileInputStream;
	Properties prop;
	public static Logger logger;
	private WebDriverEventListener events;
	private EventFiringWebDriver eDriver;

	public TestBase() {
		prop = new Properties();
		try {
			fileInputStream = new FileInputStream(
					"C:\\Users\\Gurwinder\\eclipse-workspace\\AutomationFramework2\\src\\main\\java\\com\\nopcommerce\\AutomationFramework\\Config\\Config.properties");
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
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);
	}

	public void intialisation() {
		String browserName = System.getProperty("browser");
		
		switch (browserName) {
		case "Chrome":
			wd = WebDriverManager.chromedriver().create();

			break;
		case "Edge":
			wd = WebDriverManager.edgedriver().create();
			break;
		case "Firefox":
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

		wd.get(prop.getProperty("URL"));
		wd.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICIT_WAIT")), TimeUnit.SECONDS);

		wd.manage().window().maximize();

	}

	public void tearDown() {
		wd.close();
	}

}
