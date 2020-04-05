package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public static WebDriver driver;
	public static Logger log;
	FileInputStream fis;
	Properties prop;
	
	
	
	
	@BeforeTest
	public void openBrowser() throws IOException {
	
		log=Logger.getLogger(BaseClass.class);
		PropertyConfigurator.configure("loj4j.properties");
		
		fis=new FileInputStream("./App.properties");
		prop = new Properties();
		prop.load(fis);
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://127.0.0.1:81/login.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		
	}
	
	@AfterTest
	public void closeBrowser() {
	driver.quit();	
	}
	
	@BeforeClass
	public void login() {
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("pwd")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	@AfterClass
	public void logout() {
		driver.findElement(By.className("logoutImg")).click();
	}

}