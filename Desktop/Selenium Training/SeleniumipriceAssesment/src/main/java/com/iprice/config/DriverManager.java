package com.iprice.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.iprice.Locators.Locators;

public class DriverManager implements Locators {
	public static WebDriver driver;

	public static Properties properties = new Properties();

	public DriverManager() {
		// TODO Auto-generated constructor stub
	}

	public static WebDriver getDriver() throws IOException {
		FileInputStream fis = new FileInputStream("src\\main\\java\\com\\iprice\\resources\\file.properties");
		properties.load(fis);
		String browserName = properties.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/WebDriver/chromedriver.exe");

			driver = new ChromeDriver();
		}//support multiple browsers 
		/*
		 * else if (browserName.equals("Edge")) {
		 * System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +
		 * "/WebDrivers/MicrosoftWebDriver.exe"); WebDriver driver = new EdgeDriver();
		 * // firefox code } else if (browserName.equals("ie")) { //
		 * System.setProperty("webdriver.chrome.driver", //
		 * System.getProperty("user.dir")+"/WebDrivers/IEDriverServer.exe"); WebDriver
		 * driver = new InternetExplorerDriver(); }
		 */ else {
			System.out.println("We dont support this driver.");
		}
		return driver;
	}

}
