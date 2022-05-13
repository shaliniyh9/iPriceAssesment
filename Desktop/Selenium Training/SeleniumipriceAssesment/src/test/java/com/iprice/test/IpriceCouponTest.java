package com.iprice.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.iprice.config.DriverManager;
import com.iprice.functionLib.IpriceCoupon;

public class IpriceCouponTest extends DriverManager {
	Logger Log = LogManager.getLogger(IpriceHomeTest.class.getName());
	IpriceCoupon ip;

	@BeforeTest
	public void browserSetup() throws IOException {
		/* DriverManager.getDriver().get(prop.getProperty("url")); */
		DriverManager.getDriver();
	}

	@Test
	public void ipriceCoupon() throws InterruptedException {
		ip = new IpriceCoupon(driver);
		ip.coupons();
	}

	@AfterTest
	public void driverquit() {
		driver.quit();

	}

}
