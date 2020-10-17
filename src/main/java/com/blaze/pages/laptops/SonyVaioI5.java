package com.blaze.pages.laptops;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SonyVaioI5 {
	
	@FindBy(xpath = "//a[text()='Add to cart']")
	public WebElement addToCartButton;
	
	public void clickAddToCartButton() {
		addToCartButton.click();
	}

}
