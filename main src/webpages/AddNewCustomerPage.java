package webpages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;

import utilities.BaseClass;
import utilities.ExcelOperations;

public class AddNewCustomerPage extends BaseClass{
	public static void enterCustomerName() throws EncryptedDocumentException, IOException {
		driver.findElement(By.name("name")).sendKeys(ExcelOperations.readData("Login", 0, 0));		
	}
	
	public static void clickOnCreateCustomerButton() {
		driver.findElement(By.name("createCustomerSubmit")).click();
	}
}
