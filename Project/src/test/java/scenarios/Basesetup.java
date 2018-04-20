package scenarios;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import com.google.gson.JsonObject;

import io.appium.java_client.android.AndroidDriver;

public class Basesetup {

	AndroidDriver driver;
	DesiredCapabilities capabilities;

	@BeforeClass
	public void setup() throws IOException {

		File appDir = new File("D:/Workspace/Project/src/test/resources/apps", "flipkart-5-0.apk");
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("device", "Android");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "192.168.148.101:5555");
		capabilities.setCapability("app", "Browser");
		capabilities.setCapability("platformVersion", "5.0");
		capabilities.setCapability("app", appDir.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.flipkart.android");
		capabilities.setCapability("appActivity", "com.flipkart.android.activity.HomeFragmentHolderActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		String sessionId = driver.getSessionId().toString();
		System.out.println("sessionID is " + sessionId);
		// Map<String, Object> caps = driver.getSessionDetails();

		// Screenshot
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String filename = UUID.randomUUID().toString();
		File targetFile = new File("C:/Users/shubham.dubey/Downloads/" + filename + ".jpg");
		FileUtils.copyFile(scrFile, targetFile);

		//set orientation
		//driver.rotate(ScreenOrientation.LANDSCAPE);
		// Get the current device/browser orientation
		ScreenOrientation orientation = driver.getOrientation();
		System.out.println(orientation.toString());
		
		//get location 
//		O
		
		
		Set<String> logTypes = driver.manage().logs().getAvailableLogTypes();
		System.out.println(" "+logTypes);
		
//		LogEntries logEntries = driver.manage().logs().get("driver");
//		System.out.println("Log Entries "+logEntries);
//
//
//get the seeting of the device 
		 JsonObject settings = driver.getSettings();		
		System.out.println("))))))))))))))"+ settings.get("device"));
		
		
//		String activity = driver.currentActivity();
//		System.out.println("************"+activity);
//		String pack = driver.getCurrentUrl();
		


		
		//update device settings 
		//driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, Duration.ofSeconds(5));
		
		
		
		//driver.startActivity(new Activity("com.example", "ActivityName"));




		// DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		// desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
		// "10.3");
		// desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone
		// Simulator");
		// desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
		// "XCUITest");
		// desiredCapabilities.setCapability(MobileCapabilityType.APP,
		// "/path/to/ios/app.zip");
		// URL url = new URL("http://127.0.0.1:4723/wd/hub");
		// IOSDriver driver = new IOSDriver(url, desiredCapabilities);
		// String sessionId = driver.getSessionId().toString();

	}

}
