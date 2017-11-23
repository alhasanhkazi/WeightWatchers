package com.general.scripting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BeforeAfter {
	protected WebDriver driver;
	static String sysPath = System.getProperty("user.dir");
	String libPath = sysPath + "/Lib";
	static String validFilePath = sysPath + "/Lib/SampleData.txt";

	public void launchFirefox() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Lib/geckodriver");
		driver = new FirefoxDriver();
	}

	@BeforeTest
	@Parameters("browser")
	public void beforeTest(String browser) throws Exception {
		System.out.println(libPath);

		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", libPath + "/geckodriver");
			driver = new FirefoxDriver();
			driver.get("file://" + libPath + "/WWTest.html");
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", libPath + "/chromedriver");
			driver = new ChromeDriver();
			driver.get("file://" + libPath + "/WWTest.html");
		}
		
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
