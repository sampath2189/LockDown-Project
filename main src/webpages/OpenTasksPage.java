package webpages;

import org.openqa.selenium.By;

import utilities.BaseClass;

public class OpenTasksPage extends BaseClass{
	public static void clickOnProjectsAndCustomers() {
		driver.findElement(By.linkText("Projects & Customers")).click();
	}
	
	
}

