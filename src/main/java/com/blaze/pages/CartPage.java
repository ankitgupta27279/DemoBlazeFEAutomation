package com.blaze.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blaze.utils.Constants;

public class CartPage extends BasePage{
	
	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = Constants.deleteDelli78GBText)
	public WebElement deleteDelli78GB;
	
	@FindBy(xpath = Constants.itemsAvailableInCartText)
	public List<WebElement> itemsAvailableInCart;
	
	@FindBy(className = "btn.btn-success")
	public WebElement placeOrderButton;
	
	@FindBy(id = Constants.totalAmountOnCartPageText)
	public WebElement totalAmountOnCartPageElement;
	
	public void clickDeleteItem(WebElement element) {
		element.click();
	}
	
	public int getNumberOfItemsInCart() {
		return itemsAvailableInCart.size();
	}
	
	public void clickPlaceOrderButton() {
		placeOrderButton.click();
	}
	
	public String getTotalBilledAmount() {
		return totalAmountOnCartPageElement.getText();
	}
	
}
