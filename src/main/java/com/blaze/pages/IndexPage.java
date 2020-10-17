package com.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blaze.utils.Constants;

public class IndexPage extends BasePage{
	
	public IndexPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = Constants.itemLaptops)
	public WebElement categoryLaptops;
	
	@FindBy(id = "cartur")
	public WebElement cart;
	
	public void clickCategoryLaptops() {
		categoryLaptops.click();
	}
	
	public void clickOnCart() {
		cart.click();
	}
}
