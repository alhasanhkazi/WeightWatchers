package com.mobile.automation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;


public class MapTest {
	AndroidDriver driver;
	DesiredCapabilities capabilities;
	

	@BeforeClass
	public void setUp() throws MalformedURLException {
		//Set up desired capabilities and pass the Android app-activity
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "5.1.1");
		capabilities.setCapability("deviceName", "66f3b9e8");
		capabilities.setCapability("platformName", "Android");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	

	@Test
	public void testFindRestaurant() throws Exception {
		
		//Sending app-package to Appium
		
		capabilities.setCapability("appPackage", "com.google.android.apps.maps");
		capabilities.setCapability("appActivity", "com.google.android.maps.MapsActivity"); 
		
		// Searching for nearby restaurants
		driver.findElement(By.className("android.widget.TextView")).sendKeys("restaurant near me");
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		// Selecting the first item in the list
		driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']")).click();
		
		// Opening direction optins
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Directions\")").click();							
		
		// Selecting Driving Direction
		String drivingOptionXp = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.HorizontalScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]";
		driver.findElement(By.xpath(drivingOptionXp)).click();
		
		// Retrieving driving time and printing in the console
		String drivinModeXp="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/android.support.v4.view.ViewPager[1]/android.view.View[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
		System.out.println("It's a "+driver.findElement(By.xpath(drivinModeXp)).getText()+"utes drive to nearest restaurant");						
	}

	@AfterClass
	public void teardown() {
		// close the app
		driver.quit();
	}
}
