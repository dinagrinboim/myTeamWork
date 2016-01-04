package mobileteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class AddTaskListPage extends AbstractPageObject{
	
	By m_titleTaskList = By.xpath("//android.widget.TextView[@text='Add Task List']");
	By m_descriptionTaskList = By.xpath("//android.widget.EditText[@text='Description']");
	By m_saveBtn = By.xpath("//android.widget.TextView[@text='Save']");
	
	public AddTaskListPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void setTitleTaskList(String titleTaskList){
		driver.findElement(m_titleTaskList).sendKeys(titleTaskList);
	}
	
	public void setDescriptionTaskList(String titleTaskList){
		driver.findElement(m_descriptionTaskList).sendKeys(titleTaskList);
	}
	
	public ActiveTaskListsPage clickOnSaveBtnAndGoToActiveTaskListsPage(){
		driver.findElement(m_saveBtn).click();
		return new ActiveTaskListsPage(driver);
	}
	
	@Override
	protected void assertInPage() {
		(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(m_titleTaskList));
	}
}