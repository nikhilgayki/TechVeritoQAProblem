package testPackage;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import genericMethods.*;

public class TestClass extends BaseClass {
	
	/*
	 * Description: This method will check: 
	 * 1.The maximum length of Title TextBox using maxlength Attribute.
	 * 2.The maximum length of Sku TextBox using maxlength Attribute.
	 * */
	@Test(priority = 2)
	public void verify_MaxLength_of_Title_and_Sku_fields() {
		CommonMethods.click(driver,ObjectRepository.getProductButton(driver));
		CommonMethods.click(driver,ObjectRepository.getNewProduct(driver));
		Assert.assertEquals(ObjectRepository.getTitleTextBox(driver).getAttribute("maxlength"), "40");
		Assert.assertEquals(ObjectRepository.getSkuTextBox(driver).getAttribute("maxlength"), "10");
	}
	
	/* Parameters: ProductName, Sku, Description
	 * Description: This method will check whether the Product or Sku(given parameters) is already present in the list.
	 * If not present then it will create the new product with the given parameters.
	 * */
	@Test(priority = 3)
	@Parameters({"ProductName", "Sku","Description"})
	public void verify_Product_Creation(String ProductName, String Sku, String Description) {
		CommonMethods.click(driver,ObjectRepository.getProductButton(driver));
		CommonMethods.create_Product_Method(driver, ProductName, Sku,
				Description);
		Assert.assertEquals(ObjectRepository.getMsg(driver).getText(), "Product was successfully created.");
	}
	
	/* Parameters: ProductName, Sku, Description
	 * Description: This method will check whether the Title and Sku fields are accepting the unique values
	 * */
	@Test(priority = 4)
	@Parameters({"ProductName", "Sku","Description"})
	public void verify_Unique_Fields(String ProductName, String Sku, String Description) {
		CommonMethods.click(driver,ObjectRepository.getProductButton(driver));
		CommonMethods.create_Product_Method(driver, ProductName, Sku,
				Description);
		CommonMethods.click(driver,ObjectRepository.getSubmitButton(driver));
		Assert.assertEquals(ObjectRepository.getTitleErrorMsg(driver).getText(), "has already been taken");
		Assert.assertEquals(ObjectRepository.getSkuErrorMsg(driver).getText(), "has already been taken");
	}

	/* Parameters: ProductName
	 * Description: This method will search the Product using filter form.
	 * */
	@Test(priority = 5)
	@Parameters({"ProductName"})
	public void verify_searching_Product(String ProductName) {
		CommonMethods.click(driver,ObjectRepository.getProductButton(driver));
		Assert.assertEquals(CommonMethods.searched_Title_isPresent(driver, ProductName), true);
	}

	/* Parameters: ProductName, UpdatedDescription
	 * Description: This method will search the Product and update its description.
	 * */
	@Test(priority = 6)
	@Parameters({"ProductName","UpdatedDescription"})
	public void verify_Product_Updation(String ProductName, String UpdatedDescription) {
		CommonMethods.click(driver,ObjectRepository.getProductButton(driver));
		CommonMethods.update_Product(driver,ProductName,UpdatedDescription);
		Assert.assertEquals(ObjectRepository.getMsg(driver).getText(), "Product was successfully updated.");
	}
	
	/* Parameters: ProductName, Sku
	 * Description: This method will search the Product and delete it.
	 * */
	@Test(priority = 7)
	@Parameters({"ProductName","Sku"})
	public void verify_Product_Deletion(String ProductName,String Sku) {
		CommonMethods.click(driver,ObjectRepository.getProductButton(driver));

		if (CommonMethods.searched_Title_isPresent(driver, ProductName)) {
			CommonMethods.delete_Product(driver);
		} else {
			if (CommonMethods.searched_Sku_isPresent(driver, Sku)) {
				CommonMethods.delete_Product(driver);
			} else {
				System.out.println("Searched sku is not found, Hence no delete operation performed.");
			}
		}
		Assert.assertEquals(ObjectRepository.getMsg(driver).getText(), "Product was successfully destroyed.");
	}
	
	/*
	 * Description: This method will check the available fields are mandatory: 
	 * 1. By verifying asterisk mark
	 * 2. By submitting fields without filling Test data.
	 * */
	@Test(priority = 1)
	public void verify_the_Mandatory_fields() {
		CommonMethods.click(driver,ObjectRepository.getProductButton(driver));
		CommonMethods.click(driver,ObjectRepository.getNewProduct(driver));


		WebElement asteriskTitle = ObjectRepository.getTitleAstrikes(driver);
		if (CommonMethods.verifyMandatoryField(asteriskTitle) == true) {
			CommonMethods.click(driver,ObjectRepository.getSubmitButton(driver));
			WebElement errorMessageLocator = ObjectRepository.getTitleErrorMsg(driver);
			Assert.assertEquals(errorMessageLocator.getText(), "can't be blank");
		}

		WebElement asteriskSku = ObjectRepository.getSkuAstrikes(driver);
		if (CommonMethods.verifyMandatoryField(asteriskSku) == true) {
			CommonMethods.click(driver,ObjectRepository.getSubmitButton(driver));
			WebElement errorMessageLocator = ObjectRepository.getSkuErrorMsg(driver);
			Assert.assertEquals(errorMessageLocator.getText(), "can't be blank");
		} 

		WebElement asteriskDescription = ObjectRepository.getDescriptionAstrikes(driver);
		if (CommonMethods.verifyMandatoryField(asteriskDescription) == true) {
			CommonMethods.click(driver,ObjectRepository.getSubmitButton(driver));
			WebElement errorMessageLocator = ObjectRepository.getDescriptionErrorMsg(driver);
			Assert.assertEquals(errorMessageLocator.getText(), "can't be blank");
		}
	}
}
