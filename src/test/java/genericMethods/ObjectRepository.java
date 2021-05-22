package genericMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectRepository {

	public static WebElement getUserNameTextBox(WebDriver driver) {
		return driver.findElement(By.id("admin_user_email"));
	}	
	public static WebElement getPasswordTextBox(WebDriver driver) {
		return driver.findElement(By.id("admin_user_password"));
	}	
	public static WebElement getSubmitButton(WebDriver driver) {
		return driver.findElement(By.name("commit"));
	}
	public static WebElement getFilterButton(WebDriver driver) {
		return driver.findElement(By.xpath("//form[@id='new_q']/div[6]/input[1]"));
	}
	public static WebElement getLogoutButton(WebDriver driver) {
		return driver.findElement(By.id("logout"));
	}
	public static WebElement getProductButton(WebDriver driver) {
		return driver.findElement(By.xpath("//li[@id='products']/a"));
	}
	public static WebElement getNewProduct(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@id='titlebar_right']/div/span/a"));
	}
	public static WebElement getTitleAstrikes(WebDriver driver) {
		return driver.findElement(By.xpath("//li[@id='product_title_input']/label/abbr"));
	}
	public static WebElement getSkuAstrikes(WebDriver driver) {
		return driver.findElement(By.xpath("//li[@id='product_sku_input']/div/label/abbr"));
	}	
	public static WebElement getDescriptionAstrikes(WebDriver driver) {
		return driver.findElement(By.xpath("//li[@id='product_description_input']/div/label/abbr"));
	}	
	public static WebElement getTitleTextBox(WebDriver driver) {
		return driver.findElement(By.id("product_title"));
	}	
	public static WebElement getSkuTextBox(WebDriver driver) {
		return driver.findElement(By.id("product_sku"));
	}
	public static WebElement getDescriptionTextBox(WebDriver driver) {
		return driver.findElement(By.id("product_description"));
	}
	public static WebElement getTitleErrorMsg(WebDriver driver) {
		return driver.findElement(By.xpath("//li[@id='product_title_input']/p"));
	}	
	public static WebElement getSkuErrorMsg(WebDriver driver) {
		return driver.findElement(By.xpath("//li[@id='product_sku_input']/p"));
	}
	public static WebElement getDescriptionErrorMsg(WebDriver driver) {
		return driver.findElement(By.xpath("//li[@id='product_description_input']/p"));
	}
	public static WebElement getMsg(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@id='wrapper']/div[3]/div"));
	}
	public static WebElement getTitleFilter(WebDriver driver) {
		return driver.findElement(By.xpath("//form[@id='new_q']/descendant::select[1]"));
	}
	public static WebElement getSkuFilter(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@id='q_sku_input']/select"));
	}
	public static WebElement getTitleFilterTextBox(WebDriver driver) {
		return driver.findElement(By.id("q_title"));
	}
	public static WebElement getSkuFilterTextBox(WebDriver driver) {
		return driver.findElement(By.id("q_sku"));
	}
	public static WebElement getTitleNameFromTable(WebDriver driver) {
		return driver.findElement(By.xpath("//table[@id='index_table_products']/descendant::td[3]"));
	}
	public static WebElement getSkuNameFromTable(WebDriver driver) {
		return driver.findElement(By.xpath("//table[@id='index_table_products']/descendant::td[4]"));
	}
	public static WebElement getCreateProductButton(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@id='titlebar_right']/div/span/a"));
	}
	public static WebElement getDeleteButton(WebDriver driver) {
		return driver.findElement(By.xpath("//table[@id='index_table_products']/descendant::td[8]/div/a[3]"));
	}
	public static WebElement getUpdateButton(WebDriver driver) {
		return driver.findElement(By.xpath("//table[@id='index_table_products']/descendant::td[8]/div/a[2]"));
	}
}
