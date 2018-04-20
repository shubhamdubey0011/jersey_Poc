package com.selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestFlipkart extends BaseDriver {

	// user Login
	@Test(priority = 0, alwaysRun = true, enabled = true)
	public void flipkartlogin() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//form[@autocomplete='on']/div/input)[1]")).sendKeys("Shubham0011@gmail.com");
		driver.findElement(By.xpath("(//form[@autocomplete='on']/div/input)[2]")).sendKeys("flipkart");
		driver.findElement(By.xpath("//button[@type='submit']/div")).submit();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	// Add to cart functionality
	@Test(priority = 1, enabled = false)
	public void verifyAddToCartProduct() throws InterruptedException {

		driver.findElement(By.xpath("//div[@class='row']/div/div/input")).sendKeys("samsung galaxy s5");
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		driver.findElement(By.xpath("//a[@title='Samsung Galaxy S5 (Shimmery White, 16 GB)']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String firsttab = driver.getWindowHandle();
		System.out.println("First Tab id " + firsttab);
		Set<String> alltabs = driver.getWindowHandles();
		System.out.println("number of tabs opened " + alltabs.size());
		Iterator<String> itr = alltabs.iterator();
		while (itr.hasNext()) {
			String secondTab = itr.next();
			driver.switchTo().window(secondTab);
			System.out.println("Second tab Id" + secondTab);
			driver.switchTo().window(firsttab);

		}

		driver.findElement(By.xpath("//button[@type='button']")).click();

	}

	// asas
	@Test(priority = 1, enabled = false)
	public void VerifyProductViaDropDown() throws InterruptedException {
		Actions action = new Actions(driver);
		Thread.sleep(500);
		WebElement electronics = driver.findElement(By.xpath("//a[@title='Electronics']/span"));
		action.moveToElement(electronics).build().perform();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Samsung")).click();
		WebElement heading = driver.findElement(By.xpath("//h1[text()='Samsung Mobile Phones']"));
		String Expectedtitle = heading.getText();
		System.out.println("expected Title " + Expectedtitle);
		String actualtitle = "Samsung Mobile Phones";
		System.out.println("actual title" + actualtitle);
		if (actualtitle.equals(Expectedtitle)) {
			System.out.println("user is on Samsung Mobile Phones");
		}

	}

	@AfterTest
	public void closeBrowser() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//div[text()='My Profile']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		//a[text()='Logout']
		driver.quit();

	}
}