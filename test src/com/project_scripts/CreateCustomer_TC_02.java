package com.project_scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import utilities.BaseClass;
import webpages.ActiveProjectsAndCustomers;
import webpages.AddNewCustomerPage;
import webpages.OpenTasksPage;

@Test
public class CreateCustomer_TC_02 extends BaseClass{
	public static void createCustome() throws EncryptedDocumentException, IOException {
		log.info("**********login Successful**********");
		OpenTasksPage.clickOnProjectsAndCustomers();
		log.info("**********clicked on Projects and customers link**********");
		ActiveProjectsAndCustomers.clickOnAddNewCustomer();
		log.info("**********clicked on add new customer button**********");
		AddNewCustomerPage.enterCustomerName();
		log.info("**********entered customer name**********");
		AddNewCustomerPage.clickOnCreateCustomerButton();
		log.info("**********Clicked on create customer button**********");
	}
}