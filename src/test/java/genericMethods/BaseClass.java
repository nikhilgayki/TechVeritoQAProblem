package genericMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	
	/* Parameters: Browser
	 * Description: This method will launch the browser.
	 * */
	@BeforeSuite
	@Parameters({"Browser"})
	public void setup(String Browser) {
		driver = LocalBrowserFactory.createInstance(Browser);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/* Parameters: url, Username, Password
	 * Description: This method will open the Url and Login to the application.
	 * */
	@BeforeMethod
	@Parameters({"url","Username","Password"})
	public void login(String url,String Username, String Password) {
		driver.get(url);
		ObjectRepository.getUserNameTextBox(driver).sendKeys(Username);
		ObjectRepository.getPasswordTextBox(driver).sendKeys(Password);
		CommonMethods.click(driver,ObjectRepository.getSubmitButton(driver));
		Assert.assertEquals(ObjectRepository.getMsg(driver).getText(),"Signed in successfully.");
	}
	
	/* Description: This method will Logout to the application.
	 * */
	@AfterMethod
	public void logout() {
		CommonMethods.click(driver,ObjectRepository.getLogoutButton(driver));
	}

	/* Description: This method will close the browser.
	 * */
	@AfterSuite
	public void CloseBrowser() {
		LocalBrowserFactory.tearDown();
	}
}
