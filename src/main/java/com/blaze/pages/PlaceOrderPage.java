package com.blaze.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blaze.utils.Constants;

public class PlaceOrderPage extends BasePage{

	public PlaceOrderPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = Constants.purchaseFormText)
	public WebElement purchaseForm;
	
	@FindBy(xpath = "//div[@id='orderModal']//form//input[@id='name']")
	public WebElement name;
	
	@FindBy(id = "country")
	public WebElement country;
	
	@FindBy(id = "city")
	public WebElement city;
	
	@FindBy(id = "card")
	public WebElement card;
	
	@FindBy(id = "month")
	public WebElement month;
	
	@FindBy(id = "year")
	public WebElement year;
	
	@FindBy(xpath = "//button[text()='Purchase']")
	public WebElement purchaseButtonElement;
	
	@FindBy(xpath = "//p[@class='lead text-muted ']")
	public WebElement purchaseDetailsElement;
	
	@FindBy(xpath = "//button[text()='OK']")
	public WebElement okButtonElement;
	
	public void enterTextInElement(WebElement element, String text) {
		String jsCommand = "arguments[0].setAttribute('value','"+text+"')";
		((JavascriptExecutor) driver).executeScript(jsCommand, element);
	}
	
	public String getPurchaseDetails(WebElement element) {
		String jsCommand = "return arguments[0].textContent";
		return ((JavascriptExecutor) driver).executeScript(jsCommand, element).toString();
	}
	
	public void clickPurchaseButton() {
		purchaseButtonElement.click();
	}
	
	public void clickOKButton() {
		okButtonElement.click();
	}
}
