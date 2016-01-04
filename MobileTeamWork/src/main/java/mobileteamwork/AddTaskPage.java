package mobileteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class AddTaskPage extends AbstractPageObject{

	By m_titleTask = By.xpath("//android.widget.EditText[@text='Title accepts #tag or #[big tag]']");
	//By m_titleTask = By.xpath("//android.widget.Button[@text='Cancel']");
	By m_descriptionTask = By.xpath("//android.widget.EditText[@text='Description']");
	By m_saveBtn = By.xpath("//android.widget.TextView[@text='Save']");
	
	public AddTaskPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void setTitleTask(String titleTask){
		driver.findElement(m_titleTask).sendKeys(titleTask);
	}
	
	public void setDescriptionTask(String descriptionTask){
		driver.findElement(m_descriptionTask).sendKeys(descriptionTask);
	}
	
	public TaskListPage clickOnSaveBtnAndGoToTaskListPage(){
		driver.findElement(m_saveBtn).click();
		return new TaskListPage(driver);
	}
	
	@Override
	protected void assertInPage() {
		(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(m_saveBtn));
	}
}