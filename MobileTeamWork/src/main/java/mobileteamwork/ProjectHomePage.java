package mobileteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class ProjectHomePage extends AbstractPageObject{

	By m_tasksBtn = By.xpath("//android.widget.TextView[@text='Tasks']");
	
	public ProjectHomePage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public ActiveTaskListsPage clickOnTasksBtnAndGoToActiveTaskListsPage(){
		driver.findElement(m_tasksBtn).click();
		return new ActiveTaskListsPage(driver);
	}
	
	@Override
	protected void assertInPage() {
		(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(m_tasksBtn));
	}
}