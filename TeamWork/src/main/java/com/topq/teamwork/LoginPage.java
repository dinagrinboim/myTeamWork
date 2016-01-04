package com.topq.teamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstarctPageObject{

	 private By m_userName = By.id("userLogin");
	 private By m_userPassword = By.id("password");
	 private By m_loginBtn = By.id("ordLoginSubmitBtn");
	 
	public LoginPage(WebDriver driver_) {
		super(driver_);
	}

	public void setUserName(String strUserName){
		driver.findElement(m_userName).sendKeys(strUserName);
	}
	
	public void setUserPassword(String strUserPassword){
		driver.findElement(m_userPassword).sendKeys(strUserPassword);
	}
	
	public HomePage clickLoginBtn(){
		driver.findElement(m_loginBtn).click();
		return new HomePage(driver);
	}
	
	public HomePage doLoginAndgoToOverviewPage(String strUserName,String strUserPassword){
		setUserName(strUserName);
		setUserPassword(strUserPassword);
		return clickLoginBtn();
	}
	
	@Override
	protected void assertInPage() {
		(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.id("userLogin")));
	}
}