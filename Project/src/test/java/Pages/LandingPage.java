package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import utils.UiElements;

public class LandingPage extends UiElements {

	AndroidDriver driver;

	public LandingPage(AndroidDriver driver) {
		this.driver = driver;

	}

	public void selectSkipSignupbtn() {
		
		//wait
		
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		//driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);


		//driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		driver.findElement(By.id(btn_skip)).click();
		driver.quit();

	}

}
