package mobileteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class MenuMoreOptionsPage extends AbstractPageObject{

	By m_deleteBtn = By.xpath("//android.widget.TextView[@text='Delete']");
	
	public MenuMoreOptionsPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public ConfirmationRequiredPage clickOnDeleteBtnAndGoToConfirmationRequiredPage(){
		driver.findElement(m_deleteBtn).click();
		return new ConfirmationRequiredPage(driver);
	}
	
	@Override
	protected void assertInPage() {
		(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(m_deleteBtn));
	}
}