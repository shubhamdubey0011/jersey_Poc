package scenarios;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AndroidSetup {

	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException {
		prepareAndroidForAppium();
	}

	public static void prepareAndroidForAppium() throws MalformedURLException {
		File appDir = new File("D:/Workspace/Project/src/test/resources/apps", "flipkart-5-0.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "192.168.148.101:5555");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("device", "Android");
		capabilities.setCapability("app", "Browser");
		capabilities.setCapability("app", appDir.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.flipkart.android");
		capabilities.setCapability("appActivity", "com.flipkart.android.activity.HomeFragmentHolderActivity");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.findElement(By.id("com.flipkart.android:id/btn_skip")).click();
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.findElement(By.id("com.flipkart.android:id/search_widget_textbox")).click();
		driver.findElement(By.id("com.flipkart.android:id/search_widget_textbox")).sendKeys(Keys.ARROW_DOWN);
	}
}
