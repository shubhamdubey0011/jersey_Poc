package com.selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseDriver {
	public  WebDriver driver;
	@BeforeTest
	@Parameters({ "browser" })
	
	public void browserconfig(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "D:/Workspace/AntDemo/Tool/chromedriver.exe");

			driver = new ChromeDriver();

		}

		else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "D:/Workspace/AntDemo/Tool/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", "D:/Workspace/AntDemo/Tool/geckodriver.exe");

			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("ieEdge")) {

			System.setProperty("webdriver.edge.driver", "D:/Workspace/AntDemo/Tool/MicrosoftWebDriver.exe");

			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");

	}

}
