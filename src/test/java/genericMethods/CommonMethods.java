package genericMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonMethods {

	/* Parameters: Webdriver, Sku
	 * Description: This method will search Sku.
	 * */
	public static boolean searched_Sku_isPresent(WebDriver driver, String sku) {
		boolean isPresent = false;
		try {
			CommonMethods.selectValueFromDropDown_selectByVisibleText(driver, ObjectRepository.getSkuFilter(driver), "Equals");
			CommonMethods.sendKeys(driver,ObjectRepository.getSkuFilterTextBox(driver),sku);
			CommonMethods.click(driver,ObjectRepository.getFilterButton(driver));
			if (ObjectRepository.getSkuNameFromTable(driver).getText()
					.equalsIgnoreCase(sku)) {
				isPresent = true;
			} 
		} catch (Exception e) {
			isPresent = false;
			System.out.println("Searched Title is not found");
		}
		return isPresent;
	}

	/* Parameters: Webdriver, Title
	 * Description: This method will search Title.
	 * */
	public static boolean searched_Title_isPresent(WebDriver driver, String title) {
		boolean isPresent = false;
		try {
			CommonMethods.selectValueFromDropDown_selectByVisibleText(driver, ObjectRepository.getTitleFilter(driver), "Equals");
			CommonMethods.sendKeys(driver,ObjectRepository.getTitleFilterTextBox(driver),title);
			CommonMethods.click(driver,ObjectRepository.getFilterButton(driver));
			if (ObjectRepository.getTitleNameFromTable(driver).getText()
					.equalsIgnoreCase(title)) {
				isPresent = true;
			} 
			
		} catch (Exception e) {
			isPresent = false;
		}
		return isPresent;
	}

	/* Parameters: Webdriver, asteriskLocator
	 * Description: This method will check asterisk mark for the mandatory field.
	 * */
	public static Boolean verifyMandatoryField(WebElement asteriskLocator) {
		Boolean validateField = false;

		if (asteriskLocator.getText().equals("*")) {
			Assert.assertEquals(asteriskLocator.getAttribute("title").toString(), "required");
			validateField = true;
		}
		return validateField;
	}

	/* Parameters: Webdriver, Title, Sku, Description
	 * Description: This method will add new product.
	 * */
	public static void create_Product_Method(WebDriver driver, String Title, String Sku, String Description) {
		CommonMethods.click(driver,ObjectRepository.getCreateProductButton(driver));
		CommonMethods.sendKeys(driver, ObjectRepository.getTitleTextBox(driver), Title);
		CommonMethods.sendKeys(driver, ObjectRepository.getSkuTextBox(driver),Sku);
		CommonMethods.sendKeys(driver, ObjectRepository.getDescriptionTextBox(driver),Description);
		CommonMethods.click(driver,ObjectRepository.getSubmitButton(driver));
	}
	
	/* Parameters: Webdriver
	 * Description: This method will delete the product.
	 * */
	public static void delete_Product(WebDriver driver) {
		CommonMethods.click(driver,ObjectRepository.getProductButton(driver));
		CommonMethods.click(driver,ObjectRepository.getDeleteButton(driver));
		driver.switchTo().alert().accept();
	}
	
	/* Parameters: Webdriver, ProductName, UpdatedDescription
	 * Description: This method will update the product Description.
	 * */
	public static void update_Product(WebDriver driver,String ProductName, String UpdatedDescription) {
		if (CommonMethods.searched_Title_isPresent(driver, ProductName)) {

			CommonMethods.click(driver,ObjectRepository.getUpdateButton(driver));
			ObjectRepository.getDescriptionTextBox(driver).clear();
			CommonMethods.sendKeys(driver,ObjectRepository.getDescriptionTextBox(driver),UpdatedDescription);
			CommonMethods.click(driver,ObjectRepository.getSubmitButton(driver));

		} else {
			System.out.println("Searched title is not found, Hence no update operation is performed.");
		}
	}
	
	/* Parameters: Webdriver, element
	 * Description: This method will click on the element.
	 * */
	public static void click(WebDriver driver,WebElement element) {
		explicitWait_TillElementIsClickable(driver, element);
		element.click();
	}
	
	/* Parameters: Webdriver, element, Text
	 * Description: This method will send test data to the (element)fields.
	 * */
	public static void sendKeys(WebDriver driver,WebElement element,String Text) {
		explicitWait_TillElementIsClickable(driver, element);
		element.sendKeys(Text);
	}
	
	/* Parameters: Webdriver, element
	 * Description: This method will wait till the element To Be Clickable.
	 * */
	public static void explicitWait_TillElementIsClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/* Parameters: Webdriver, element
	 * Description: This method will select Value From DropDown depends upon selectByVisibleText.
	 * */
	public static void selectValueFromDropDown_selectByVisibleText(WebDriver driver,WebElement element,String Text) {
		explicitWait_TillElementIsClickable(driver, element);
		Select dropDown = new Select(element);
		dropDown.selectByVisibleText(Text);
	}
}
