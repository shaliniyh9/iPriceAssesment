package com.iprice.functionLib;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

public class IpriceCoupon extends DriverManager implements Locators {

	Logger Log = LogManager.getLogger(IpriceCoupon.class.getName());
	public WebDriver driver;
	public WebDriverWait wait;
	static final int TIMEOUT = 40;
	static final int POLLING = 100;

	public IpriceCoupon(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	}

	public void coupons() {
		Log.info("Entered class Coupon to validate broken link or valid link and redirection " + Log.getClass());
		driver.get(properties.getProperty("ipriceCoupon"));
		Log.info("Getting website link to automate the process" + Log.getClass());
		List<WebElement> topStoresLink = driver.findElements(topStores);
		for (WebElement topStore : topStoresLink) {
			String url = topStore.getAttribute("href");
			HttpURLConnection huc = null;
			int respCode = 200;
			try {
				huc = (HttpURLConnection) new URL(url).openConnection();
				Log.info("Opening connection to validate the response from the url" + Log.getClass());
				huc.setRequestMethod("GET");
				huc.setRequestProperty("Content-Type", "application/json");
				huc.setRequestProperty("User-Agent",
						"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4896.143 Safari/537.36");
				huc.connect();
				respCode = huc.getResponseCode();

				if (respCode >= 400) {
					Log.info(url + " is a broken link. Response code is + " + respCode);
					System.out.println(url + " is a broken link");
				} else {
					Log.info(url + " is a valid link. Response code is + " + respCode);
					System.out.println(url + " is a valid link");

				}

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//code for the redirection of correct url

		for (int i = 0; i < topStoresLink.size(); i++) {
			Log.info("Iterating the top stores link " + Log.getClass());
			if (topStoresLink.get(i).isDisplayed() == true) {
				String url = topStoresLink.get(i).getAttribute("href");
				System.out.println("Links are : " + url);
				Log.info("Iterating the top stores link " + Log.getClass());
				// now click link one by one
				topStoresLink.get(i).click();
				if (url.equals(driver.getCurrentUrl())) {
					Log.info("Checking redirected is same as current url");
					Log.info("Redirected to correct url");
					
				}
				driver.navigate().to(properties.getProperty("ipriceCoupon"));
				topStoresLink = driver.findElements(topStores);

			}
		}
	}
}