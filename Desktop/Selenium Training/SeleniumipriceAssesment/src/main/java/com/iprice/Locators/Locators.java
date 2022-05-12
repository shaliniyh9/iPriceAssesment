package com.iprice.Locators;

import org.openqa.selenium.By;

public interface Locators {
	By listOfStores = By.xpath("//div[@class='bg']/div[1]/*['amp-carousel'][2]");
	By countOfStores = By.xpath("//a[starts-with(@class,'G d cP')][@role='listitem']");
	By countOfTopTrending = By.xpath("//a[starts-with(@class,'ba iI Y p')][@role='listitem']");
	By topStores = By.xpath("//div[@data-uat='coupon-store-item']/a");
	
}
