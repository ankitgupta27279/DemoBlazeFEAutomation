package com.blaze.utils;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtilities {

	public WebDriver driver = null;
	public WebDriverWait wait = null;
	
	public CommonUtilities(WebDriver driver){
		this.driver = driver;
	}
	
	public void setDriver(WebDriver driver){
		if(driver == null){
			this.driver = driver;
		}
	}

	public WebDriver getDriver(){
		return driver;
	}
	
	public void clickAddToCartButton() {
		waitForElement(Constants.addToCartByElement, Constants.MAX_WAIT_TIME);
		driver.findElement(Constants.addToCartByElement).click();
	}
	
	public void clickHomeLinkButton() {
		waitForElement(Constants.homeLinkElement, Constants.MAX_WAIT_TIME);
		driver.findElement(Constants.homeLinkElement).click();
	}
	
	public void clickCartLinkButton() {
		waitForElement(Constants.cartLinkElement, Constants.MAX_WAIT_TIME);
		driver.findElement(Constants.cartLinkElement).click();
	}
	
	public void clickPlaceOrderButton() {
		waitForElement(Constants.placeOrderButtonElement, Constants.MAX_WAIT_TIME);
		driver.findElement(Constants.placeOrderButtonElement).click();
	}

	public void clickElement(By byObject) {
		waitForElement(byObject, Constants.MAX_WAIT_TIME);
		driver.findElement(byObject).click();
	}
	
	public void launchURL(String url){
		driver.get(url);
	}
	
	public void handleAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		assertEquals(alert.getText(), Constants.productAddedText);
		alert.accept();
	}
	
	public void waitForElement(final By byObject, long timeInSeconds){
		try{
			(new WebDriverWait(driver, timeInSeconds)).until(new ExpectedCondition<WebElement>() {
				@Override
				public WebElement apply(WebDriver d){
					return d.findElement(byObject);
				}
			});
		}catch(Exception e){
			System.out.println("in catch - within "+timeInSeconds+"sec element could not be found");
		}	
	}

	public boolean isElementVisible(By byObject){
		if(driver.findElements(byObject).size()>0){
			return true;
		}else{
			return false;
		}
	}
}
