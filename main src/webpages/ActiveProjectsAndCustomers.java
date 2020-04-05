package webpages;

import org.openqa.selenium.By;

import utilities.BaseClass;

public class ActiveProjectsAndCustomers	 extends BaseClass{
	public static void clickOnAddNewCustomer() {
		driver.findElement(By.xpath("//*[@value='Add New Customer']")).click();
	}
	
	public static void clickOnAddNewProject() {
		driver.findElement(By.xpath("//*[@value='Add New Project']")).click();
	}	
}
