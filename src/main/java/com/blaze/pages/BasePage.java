package com.blaze.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

	public WebDriver driver = null;
	
	public BasePage(WebDriver driver){
		this.driver = driver;
	}
	
}
