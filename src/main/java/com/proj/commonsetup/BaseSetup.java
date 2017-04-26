package com.proj.commonsetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class BaseSetup {

	WebDriver driver;
	
		
	public WebDriver selectBrowser(String browser,String url) {
		if (browser.equals("firefox") || browser.equals("FIREFOX")) {
			driver = new FirefoxDriver();
			driver.get(url);
			driver.manage().window().maximize();
		
			return driver;
		} else if (browser.equals("chrome") || browser.equals("CHROME")) {
			System.out.println("chrome browser");
			System.setProperty("webdriver.chrome.driver","D:\\Sabi\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
		
			return driver;
		
		}
		return null;
	}
	
	@AfterClass
	public void closeBrowser() {
		//driver = null;
		driver.close();
	}

}
