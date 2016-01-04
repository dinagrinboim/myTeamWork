package com.topq.testteamwork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriver{
	
	public enum Browsers{
		CHROME,
		FIREFOX
	}

	public static WebDriver getDriver(Browsers nameOfBrowser){
		WebDriver driver = null;
		switch(nameOfBrowser){
			case CHROME:{
				System.setProperty("webdriver.chrome.driver", "/home/developer/driver/chromedriver");
				driver=  new ChromeDriver();
				break;
			}
			case FIREFOX:{
				driver=  new FirefoxDriver();
				break;
			}		
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;		
	}	
}