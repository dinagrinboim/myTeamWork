package com.topq.testteamwork;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.topq.teamwork.HomePage;
import com.topq.teamwork.LoginPage;
import com.topq.teamwork.MilestonesPage;
import com.topq.teamwork.TasksListPage;
import com.topq.teamwork.TasksPage;
import com.topq.testteamwork.BrowserDriver.Browsers;

public class TestLogin {

	private WebDriver driver = BrowserDriver.getDriver(Browsers.FIREFOX); 
    
	private String url = SingletonFileConfiguration.getInstance().getMyProperties("url");
	private String username = SingletonFileConfiguration.getInstance().getMyProperties("username");
	private String password = SingletonFileConfiguration.getInstance().getMyProperties("password");
    private String titleTaskList = "My first project of TeamWork too";
    private String titleFirstTask = "Create two tasks";
    private String titleSecondTask = "Delete the tasks";
	
	@BeforeMethod
	public void setup(){
		/*driver.get("http://topq.teamwork.com");*/			
		driver.get(url);
	}
	
	//@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void testCreatNewTaskList() throws InterruptedException{
		
		Reporter.log("User Logged in with username and password");		
		LoginPage loginPage = new LoginPage(driver);	
		HomePage homePage = loginPage.doLoginAndgoToOverviewPage(username, password);
		
		Reporter.log("Create new task list");
		TasksPage tasksPage = homePage.clickOnTasksMenuItmAndGoToTasksPage();		
		tasksPage.clickOnAddTaskBtn();
		tasksPage.setNameOfNewTaskList(titleTaskList);
		tasksPage.btnCreateTaskList();

		Reporter.log("Add two tasks to task list");
		TasksListPage tasksList = tasksPage.clickOnTaskListNameOnLeftPage(titleTaskList);
		tasksList.clickOnAddTheFirstTaskBtn();
		tasksList.addTasksToTheList(titleFirstTask);
		tasksList.addTasksToTheList(titleSecondTask);
		
		Reporter.log("Click on mileStones item on the menu and then click again on the task item");
		MilestonesPage mileStones = tasksList.goToMilstonesPage();
		mileStones.clickOnTasksMenuItm();
		
		Reporter.log("Verify task list exits");
		Assert.assertTrue(tasksPage.verifyTaskListExits(titleTaskList),"The task is not exit");
		
		Reporter.log("Delete task list");
		tasksPage.deleteTaskList(titleTaskList);
	}		
}		