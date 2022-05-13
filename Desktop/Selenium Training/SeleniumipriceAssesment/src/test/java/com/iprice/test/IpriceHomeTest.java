package com.iprice.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.iprice.config.DriverManager;
import com.iprice.functionLib.IpriceHome;

public class IpriceHomeTest extends DriverManager {

	Logger Log = LogManager.getLogger(IpriceHomeTest.class.getName());
	IpriceHome ip;

	@BeforeTest
	public void browserSetup() throws IOException {
		/* DriverManager.getDriver().get(prop.getProperty("url")); */
		DriverManager.getDriver();
	}

	@Test
	public void ipriceHomeTestfind() throws InterruptedException {
		ip = new IpriceHome(driver);
		ip.ipriceHome();
	}

	@AfterTest
	public void driverquit() {
		driver.quit();

	}

}
