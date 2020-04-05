package com.customer_scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import utilities.BaseClass;
import webpages.ActiveProjectsAndCustomers;
import webpages.AddNewProjectPage;
import webpages.OpenTasksPage;

public class CreateProject_TC_01 extends BaseClass{
	
	@Test
	public static void createProjecct() throws EncryptedDocumentException, IOException {
		
		log.info("**********login Successful**********");
		OpenTasksPage.clickOnProjectsAndCustomers();
		log.info("**********clicked projects and customers**********");
		ActiveProjectsAndCustomers.clickOnAddNewProject();
		log.info("**********clicked on Add New project button**********");
		AddNewProjectPage.enterProjectName();
		log.info("**********entered project name**********");
		AddNewProjectPage.clickOnCreateProject();
		log.info("**********cliked create project button**********");
	}
}