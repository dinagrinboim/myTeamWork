package mobileteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends AbstractPageObject{

	By m_userName = By.className("android.widget.EditText");
	By m_userPassword = By.className("android.widget.TextView");
	By m_loginBtn = By.className("android.widget.Button");
	
	public LoginPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void setUserName(String userName){
		driver.findElement(m_userName).sendKeys(userName);
	}
	
	public void setUserPassword(String userPassword){
		driver.findElement(m_userPassword).sendKeys(userPassword);
	}
	
	public AllActivityPage clickOnLoginBtnAndGoToActiveTaskLists(){
		driver.findElement(m_loginBtn).click();
		return new AllActivityPage(driver);
	}
	
	@Override
	protected void assertInPage() {
		(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(m_userName));
	}
}