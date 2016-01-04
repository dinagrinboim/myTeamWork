package com.topq.teamwork;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TasksPage extends AbstractTeamWorkPage{

	By m_addTask = By.xpath("//div/ul/li/button[@class='btn btn-success btn-hasIcon']");
	By m_newTaskListName = By.id("newTaskListName");
	By m_btnCreateTaskList = By.id("btnCreateTaskList");
	By m_numOfTasks = By.xpath("//div[@class='task topTask']");
	By m_btnOptions = By.xpath("//button[@class='btn btn-default btn-hasIcon tipped']");
	By m_btnDelete = By.xpath("//button[@class='btn btn-default btn-hasIcon tipped']");
	
	public TasksPage(WebDriver driver_) {
		super(driver_);
	}

	public void clickOnAddTaskBtn() throws InterruptedException{
//		Thread.sleep(5000);
		driver.findElement(m_addTask).click();
	}
	
	public void setNameOfNewTaskList(String strNewTaskListName){
		driver.findElement(m_newTaskListName).sendKeys(strNewTaskListName);
	}
	
	public void btnCreateTaskList(){
		driver.findElement(m_btnCreateTaskList).click();
	}
	
	public void doTasks(String strNewTaskListName) throws InterruptedException{
	//	Thread.sleep(5000);
		clickOnAddTaskBtn();
		setNameOfNewTaskList(strNewTaskListName);
		btnCreateTaskList();
	}
	
	public TasksListPage clickOnTaskListNameOnLeftPage(String listName){
		WebElement listTaskName = driver.findElement(By.linkText(listName));//("//span[contains(.,'"+ listName +"')]"));
		listTaskName.click();
		return new TasksListPage(driver); 
	}
	
	public boolean verifyTaskListExits(String nameOfTaskList) throws InterruptedException{
	//	Thread.sleep(5000);
		WebElement listTaskName = driver.findElement(By.linkText(nameOfTaskList));
		listTaskName.click();
//		Thread.sleep(3000);
		List<WebElement> tasks = driver.findElements(m_numOfTasks);
//		Thread.sleep(3000);
		return (tasks.size() == 2);
	}
	
	public void deleteTaskList(String nameOfTaskList){
		WebElement listTaskName = driver.findElement(By.linkText(nameOfTaskList));//xpath("//span[contains(.,'"+ nameOfTaskList +"')]"));
		listTaskName.click();
		driver.findElement(m_btnOptions).click();
		driver.findElement(m_btnDelete).click();
	}
	
	@Override
	protected void assertInPage() {
		(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.id("pageTitle")));	
	}
}