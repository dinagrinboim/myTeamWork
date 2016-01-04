package com.topq.teamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class AbstractTeamWorkPage extends AbstarctPageObject{

	By m_tabTask = By.xpath("//li[@id='tab_tasks']");
	
	public AbstractTeamWorkPage(WebDriver driver_) {
		super(driver_);
	}

	public TasksPage clickOnTasksMenuItm(){
		driver.findElement(m_tabTask).click();
		return new TasksPage(driver);
	}
}