package com.blaze.utils;

import org.openqa.selenium.By;

public class Constants {
	
	public static final Long MAX_WAIT_TIME = 10L;
	
	public static final String homeLinkText = "//a[@href='index.html' and text()='Home ']";
	public static final String cartIDText = "cartur";
	public static final String productAddedText = "Product added";
	public static final String webURL = "https://www.demoblaze.com/index.html";
	public static final String addToCartButtonString = "//a[text()='Add to cart']";
	public static final String itemSonyVaioI5Laptop = "//a[text()='Sony vaio i5']";
	public static final String itemDelli78GBLaptop = "//a[text()='Dell i7 8gb']";
	public static final String itemLaptops = "//a[@id='itemc' and text()='Laptops']";
	public static final String itemsAvailableInCartText = "//tbody[@id='tbodyid']/tr";
	public static final String deleteDelli78GBText = "//td[text()='Dell i7 8gb']/following-sibling::td[2]/a";
	public static final String placeOrderButtonText = "//button[text()='Place Order']";
	public static final String purchaseFormText = "//div[@id='orderModal']/div/div";
	public static final String totalAmountOnCartPageText = "totalp";
	
	public static final String name = "Albert Speer";
	public static final String country = "Germany";
	public static final String city = "Munich";
	public static final String card = "1234-5678-9012-3456";
	public static final String month = "Dec";
	public static final String year = "2022";
	
	public static By addToCartByElement = By.xpath(addToCartButtonString);
	public static By SonyVaioI5LaptopElement = By.xpath(itemSonyVaioI5Laptop);
	public static By Delli78GBLaptopElement = By.xpath(itemDelli78GBLaptop);
	public static By homeLinkElement = By.xpath(homeLinkText);
	public static By itemLaptopsElement = By.xpath(itemLaptops);
	public static By cartLinkElement = By.id(cartIDText);
	public static By itemsAvailableInCartElement = By.xpath(itemsAvailableInCartText);
	public static By deleteDelli78GBElement = By.xpath(deleteDelli78GBText);
	public static By placeOrderButtonElement = By.xpath(placeOrderButtonText);
	public static By purchaseFormElement = By.xpath(purchaseFormText);
}
