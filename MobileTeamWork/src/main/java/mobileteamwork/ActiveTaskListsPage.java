package mobileteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class ActiveTaskListsPage extends AbstractPageObject{
	
	public ActiveTaskListsPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public AddTaskListPage clickOnAddTaskListBtnAndGoToAddTaskListPage(){
		driver.scrollTo("Add Task List").click();
		return new AddTaskListPage(driver);
	}
	
	public TaskListPage clickOnDesiredTaskListAndGoToTaskListPage(String nameOfDesiredTaskList){
		driver.scrollTo(nameOfDesiredTaskList).click();
		return new TaskListPage(driver);
	}	
	
	@Override
	protected void assertInPage() {
		(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Active Task Lists'])")));
	}
}