package testmobileteamwork;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import mobileteamwork.ActiveTaskListsPage;
import mobileteamwork.AddTaskListPage;
import mobileteamwork.AddTaskPage;
import mobileteamwork.AllActivityPage;
import mobileteamwork.AllProjectPage;
import mobileteamwork.ConfirmationRequiredPage;
import mobileteamwork.LoginPage;
import mobileteamwork.MenuMoreOptionsPage;
import mobileteamwork.ProjectHomePage;
import mobileteamwork.SubMenuPage;
import mobileteamwork.TaskListPage;

public class TestMobileTeamWork {

	private AndroidDriver<WebElement> driver;
	private String userName = "fake09@fake.com";
	private String userPassword = "fake";
	private String titleTaskList = "My first task list";
	private String descriptionTaskList = "In my first task list, I create two tasks";
	private String titleFirstTask = "Task1";
	private String descriptionFirstTask = "Create two tasks";
	private String titleSecondTask = "Task2";
	private String descriptionSecondTask = "Delete two tasks";
	private String nameOfWebDriver = "WebDriver Training";

	@BeforeMethod
	public void setUp() throws Exception {
		File app = new File("teamwork.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "google Galaxy Nexus - 4.2.2 - API 17 - 720x1280");
		capabilities.setCapability("platformVersion", "4.2.2");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "net.teamworkpm.phone");
		capabilities.setCapability("appActivity", ".ProjectsActivity");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void testLogin() throws InterruptedException {
		
		Reporter.log("Application AppTeamWork is opened");
		LoginPage loginPage = new LoginPage(driver);
		
		Reporter.log("User is Logged in with name and password");
		loginPage.setUserName(userName);
		loginPage.setUserPassword(userPassword);
		AllActivityPage allActivityPage = loginPage.clickOnLoginBtnAndGoToActiveTaskLists();
		
		Reporter.log("Click on project item in sub menu");
		SubMenuPage subMenuPage = allActivityPage .clickOnSubMenuItmAndGoToSubMenuPage();
		AllProjectPage allProjectPage = subMenuPage.clickOnProjectItmAndGoToAllProjectPage();
		
		Reporter.log("Choose Project of task list");
		ProjectHomePage projectHomePage = allProjectPage.clickOnwebDriverItmAndGoToProjectHomePage(nameOfWebDriver);
		
		Reporter.log("Create new task list with title and description");		
		ActiveTaskListsPage activeTaskListsPage = projectHomePage.clickOnTasksBtnAndGoToActiveTaskListsPage();
		AddTaskListPage addTaskListPage = activeTaskListsPage.clickOnAddTaskListBtnAndGoToAddTaskListPage();
		addTaskListPage.setTitleTaskList(titleTaskList);	
		addTaskListPage.setDescriptionTaskList(descriptionTaskList);
		activeTaskListsPage = addTaskListPage.clickOnSaveBtnAndGoToActiveTaskListsPage();
		
		Reporter.log("Create the first task of task list");
		TaskListPage taskListPage = activeTaskListsPage.clickOnDesiredTaskListAndGoToTaskListPage(titleTaskList);
		AddTaskPage addTaskPage = taskListPage.clickOnCreateTheFirstTaskBtnAndGoToAddTaskPage();
		addTaskPage.setTitleTask(titleFirstTask);
		addTaskPage.setDescriptionTask(descriptionFirstTask);
		taskListPage = addTaskPage.clickOnSaveBtnAndGoToTaskListPage();
		
		Reporter.log("Create the second task of task list");
		addTaskPage = taskListPage.clickOnAddTaskBtnAndGoToAddTaskPage();
		addTaskPage.setTitleTask(titleSecondTask);
		addTaskPage.setDescriptionTask(descriptionSecondTask);
		addTaskPage.clickOnSaveBtnAndGoToTaskListPage();
		
		Reporter.log("Delete tasks of task list");
		MenuMoreOptionsPage menuMoreOptionsPage = taskListPage.clickOnMenuMoreOptionsBtnAndGoToMenuMoreOptionsPage();
		ConfirmationRequiredPage confirmationRequiredPage = menuMoreOptionsPage.clickOnDeleteBtnAndGoToConfirmationRequiredPage();
		confirmationRequiredPage.clickOnDeleteBtnAndGoToActiveTaskListsPage();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
}