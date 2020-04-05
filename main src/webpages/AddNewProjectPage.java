package webpages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;

import utilities.BaseClass;
import utilities.ExcelOperations;

public class AddNewProjectPage extends BaseClass{
	public static void enterProjectName() throws EncryptedDocumentException, IOException {
		driver.findElement(By.name("name")).sendKeys(ExcelOperations.readData("login", 0, 1));
	}
	
	public static void clickOnCreateProject() {
		driver.findElement(By.name("createProjectSubmit")).click();
	}
	
}