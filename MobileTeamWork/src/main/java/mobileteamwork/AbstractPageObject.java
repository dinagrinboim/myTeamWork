package mobileteamwork;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class AbstractPageObject {

	protected final AndroidDriver<WebElement> driver;

	public AbstractPageObject(AndroidDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	protected void assertInPage() {		
	}
}