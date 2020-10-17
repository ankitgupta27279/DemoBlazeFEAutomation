	package com.blaze.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.blaze.utils.ConfigSetUp;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver = null;
	
	@BeforeTest(alwaysRun = true)
	@Parameters({"deviceType", "platformName", "platformVersion", "deviceName", "browser"})
	public void initSetUp(String deviceType, String platformName, String platformVersion, String deviceName, String browser) {
		initDriver(deviceType, platformName, platformVersion, deviceName, browser);
	}
	
	public void initDriver(String deviceType, String platformName, String platformVersion, String deviceName, String browser) {
		if(browser.equalsIgnoreCase(ConfigSetUp.Browser.Chrome.toString())) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase(ConfigSetUp.Browser.Firefox.toString())) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
