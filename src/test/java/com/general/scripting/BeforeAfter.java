package com.general.scripting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BeforeAfter {
	protected WebDriver driver;
	static String sysPath =  System.getProperty("user.dir");
	String libPath = sysPath +"/Lib";
	static String validFilePath = sysPath+"/Lib/SampleData.txt";
	
	@BeforeTest
	public void beforeTest() {
		
		System.out.println(libPath);
		System.setProperty("webdriver.chrome.driver", libPath+ "/chromedriver");
		driver = new ChromeDriver();
		driver.get("file://"+libPath+"/WWTest.html");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	
}
