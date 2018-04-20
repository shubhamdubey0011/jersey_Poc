package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.android.AndroidDriver;
import utils.UiElements;

public class HomePage extends UiElements
{

	AndroidDriver driver;
	
	public HomePage(AndroidDriver driver) 
	{
	  this.driver=driver;
	  
	  
	}
	
	
	public void verifySelectCategory()
	{
	
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.findElement(By.xpath(HomeImprovementTools_Category));
		
	}
	
	
	
	
}
