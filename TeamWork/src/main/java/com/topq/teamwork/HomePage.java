package com.topq.teamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractTeamWorkPage{
	
	public HomePage(WebDriver driver_) {
		super(driver_);
	}
	
	public TasksPage clickOnTasksMenuItmAndGoToTasksPage(){			
		return this.clickOnTasksMenuItm();
	}
		
	@Override
	protected void assertInPage() {
		(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.id("pageTitle")));
	}
}