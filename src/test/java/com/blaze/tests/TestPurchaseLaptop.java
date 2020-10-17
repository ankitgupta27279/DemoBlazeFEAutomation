package com.blaze.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.blaze.pages.CartPage;
import com.blaze.pages.IndexPage;
import com.blaze.pages.PlaceOrderPage;
import com.blaze.pages.categories.LaptopsPage;
import com.blaze.utils.CommonUtilities;
import com.blaze.utils.Constants;

public class TestPurchaseLaptop extends BaseTest{

	private IndexPage indexPage = null;
	private CommonUtilities commonUtils = null;
	private LaptopsPage laptopsPage = null;
	private CartPage cartPage = null;
	private PlaceOrderPage placeOrderPage = null;
	private String totalBilledAmountOnCartPage = null;
	private String finalPurchaseDetails = null;
	private String totalAmountPaidByUser = null;
	
	@BeforeTest
	public void initConstr() {
		indexPage = new IndexPage(driver);
		laptopsPage = new LaptopsPage(driver);
		cartPage = new CartPage(driver);
		commonUtils = new CommonUtilities(driver);
		placeOrderPage = new PlaceOrderPage(driver);
	}
	
	@Test(priority=1)
	public void accessDemoBlazeApp() {
		commonUtils.launchURL(Constants.webURL);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 2)
	public void addingSonyVaioi5LaptopToCart() {
		indexPage.clickCategoryLaptops();
		commonUtils.waitForElement(Constants.SonyVaioI5LaptopElement, Constants.MAX_WAIT_TIME);
		laptopsPage.clickItem(laptopsPage.SonyVaioI5Laptop);
		commonUtils.waitForElement(Constants.addToCartByElement, Constants.MAX_WAIT_TIME);
		commonUtils.clickAddToCartButton();
		commonUtils.handleAlert();
	}
	
	@Test(priority = 3)
	public void addingDelli78GBLatopToCart() {
		commonUtils.clickHomeLinkButton();
		commonUtils.waitForElement(Constants.itemLaptopsElement, Constants.MAX_WAIT_TIME);
		indexPage.clickCategoryLaptops();
		commonUtils.waitForElement(Constants.Delli78GBLaptopElement, Constants.MAX_WAIT_TIME);
		laptopsPage.clickItem(laptopsPage.Delli78GBLaptop);
		commonUtils.waitForElement(Constants.addToCartByElement, Constants.MAX_WAIT_TIME);
		commonUtils.clickAddToCartButton();
		commonUtils.handleAlert();
	}
	
	@Test(priority = 4)
	public void deletingDelli78GBLaptopFromCart() throws InterruptedException {
		commonUtils.clickCartLinkButton();
		commonUtils.waitForElement(Constants.itemsAvailableInCartElement, Constants.MAX_WAIT_TIME);
		assertEquals(cartPage.getNumberOfItemsInCart(), 2);
		commonUtils.clickElement(Constants.deleteDelli78GBElement);
		Thread.sleep(5000);
		commonUtils.waitForElement(Constants.itemsAvailableInCartElement, Constants.MAX_WAIT_TIME);
		assertEquals(cartPage.getNumberOfItemsInCart(), 1);
	}
	
	@Test(priority = 5)
	public void clickPlaceOrder() {
		totalBilledAmountOnCartPage = cartPage.getTotalBilledAmount();
		commonUtils.clickPlaceOrderButton();
	}
	
	@Test(priority = 6)
	public void fillPurchaseForm() {
		placeOrderPage.enterTextInElement(placeOrderPage.name, Constants.name);
		placeOrderPage.enterTextInElement(placeOrderPage.country, Constants.country);
		placeOrderPage.enterTextInElement(placeOrderPage.city, Constants.city);
		placeOrderPage.enterTextInElement(placeOrderPage.card, Constants.card);
		placeOrderPage.enterTextInElement(placeOrderPage.month, Constants.month);
		placeOrderPage.enterTextInElement(placeOrderPage.year, Constants.year);
		// placeOrderPage.clickPurchaseButton();
	}
	
	@Test(priority = 7)
	public void clickPurchaseForm() {
		placeOrderPage.clickPurchaseButton();
	}
	
	@Test(priority = 8)
	public void capturePurchaseIDAndAmount() {
		finalPurchaseDetails = placeOrderPage.getPurchaseDetails(placeOrderPage.purchaseDetailsElement);
	}
	
	@Test(priority = 9)
	public void assertPurchaseAmountEqualsExpected() {
		totalAmountPaidByUser = finalPurchaseDetails.split("Amount: ")[1].split(" USDCard")[0];
		assertEquals(totalAmountPaidByUser, totalBilledAmountOnCartPage);
	}
	
	@Test(priority = 10)
	public void clickedOKButton() {
		placeOrderPage.clickOKButton();
	}
	
}
