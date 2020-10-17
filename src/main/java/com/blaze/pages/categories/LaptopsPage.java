package com.blaze.pages.categories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blaze.pages.BasePage;
import com.blaze.utils.Constants;

public class LaptopsPage extends BasePage{

	public LaptopsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = Constants.itemSonyVaioI5Laptop)
	public WebElement SonyVaioI5Laptop;
	
	@FindBy(xpath = Constants.itemDelli78GBLaptop)
	public WebElement Delli78GBLaptop;
	
	public void clickItem(WebElement element) {
		element.click();
	}
}
