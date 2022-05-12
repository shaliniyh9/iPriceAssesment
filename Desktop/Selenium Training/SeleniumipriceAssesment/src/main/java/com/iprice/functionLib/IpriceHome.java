package com.iprice.functionLib;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.iprice.Locators.Locators;
import com.iprice.config.DriverManager;


public class IpriceHome extends DriverManager  implements Locators {
	public WebDriver driver;
	public WebDriverWait wait;
	static final int TIMEOUT = 40;
	static final int POLLING = 100;
	Logger Log = LogManager.getLogger(IpriceCoupon.class.getName());
	public IpriceHome(WebDriver driver)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	}

	public void ipriceHome() throws InterruptedException {
		Log.info("Entered class IpriceHome to count no of stores and displaying list of the stores " + Log.getClass());
		driver.get(properties.getProperty("ipriceHome"));
		List<WebElement> bestDeals = driver.findElements(listOfStores);

		for (WebElement bestDeal : bestDeals) {
			System.out.println(bestDeal.getText());
			Log.info("The list of the stores are " + bestDeal.getText());
		}
		List<WebElement> bestDealsCount = driver.findElements(countOfStores);
		System.out.println(bestDealsCount.size());
		Log.info("The count of the stores are  " +bestDealsCount.size());

		List<WebElement> countTopTrending = driver.findElements(countOfTopTrending);
		System.out.println(countTopTrending.size());
		Log.info("The count of the stores are  " +countTopTrending.size());
		Iterator<WebElement> itr = countTopTrending.iterator();
		while (itr.hasNext()) {
			String attributeValue = itr.next().getAttribute("data-vars-cgt");
			if (attributeValue != null && attributeValue.isEmpty()) {
				System.out.println("Item contains data-vars-cgt");
				Log.info("Item contains data-vars-cgt");
			} else {
				Log.info("Item contains data-vars-cgt");
			}
		}

	}
}
