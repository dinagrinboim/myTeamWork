package mobileteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class SubMenuPage extends AbstractPageObject{

	By m_projectItm = By.xpath("//android.widget.TextView[@text='Projects']");
	
	public SubMenuPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public AllProjectPage clickOnProjectItmAndGoToAllProjectPage(){
		driver.findElement(m_projectItm).click();
		return new AllProjectPage(driver);
	}
	
	@Override
	protected void assertInPage() {
		(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(m_projectItm));
	}
}