package com.topq.teamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TasksListPage extends AbstractTeamWorkPage{

	By m_addFirstTask = By.xpath("//button[@class='btn btn-success js-add-task btn-lg']");
	By m_FirstTaskTextBox = By.xpath("//form[@id='newTaskForm']//following::span/input[@placeholder]");
	By m_saveMyChangesBtn = By.xpath("//input[@value='Save my changes']");
	By m_goToMilestones = By.xpath("//li[@id='tab_messages']");
	
	public TasksListPage(WebDriver driver_) {
		super(driver_);
	}

	public void clickOnAddTheFirstTaskBtn(){
		driver.findElement(m_addFirstTask).click();
	}
	public void sendKeyToTaskTextBox(String strTask){
		//WebElement element = (new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(m_FirstTaskTextBox));
		//element.sendKeys(strTask);
		driver.findElement(m_FirstTaskTextBox).sendKeys(strTask);
	}
	public void saveTask(){
		driver.findElement(m_saveMyChangesBtn).click();
	}
	
	public void addTasksToTheList(String strTask) throws InterruptedException{
		Thread.sleep(3000);
		
		sendKeyToTaskTextBox(strTask);
		saveTask();
	}	

	public MilestonesPage goToMilstonesPage() {
		driver.findElement(m_goToMilestones).click();
		return new MilestonesPage(driver);
	}
		
	@Override
	protected void assertInPage() {		
		(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(m_addFirstTask));
	}
}