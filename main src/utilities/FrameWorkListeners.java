package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class FrameWorkListeners {
	ExtentHtmlReporter reporter;
	ExtentReports extent;
	ExtentTest test;
	
	public void onStart(ITestContext rv) {
		String date = new SimpleDateFormat("yyyyMMss hh:mm:ss").format(new Date());
		String reportName = "Test-Report"+date+".html";
		reporter = new ExtentHtmlReporter("./test-output"+reportName);
		reporter.config().setDocumentTitle("DemoTitle");
		reporter.config().setReportName("Build result");
		reporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA", "sampath");
		extent.setSystemInfo("Browser", "Chrome 81");
		extent.setSystemInfo("OS", "windows 10");
	}
	
	public void onFinish(ITestResult rv) {
		extent.flush();
	}
	
	public void onTestStart(ITestResult rv) {
		test= extent.createTest(rv.getName());
	}
	
	public void onTestSuccess(ITestResult rv) {
		test.log(Status.PASS, MarkupHelper.createLabel("Successfully executed", ExtentColor.GREEN));
	}
	
	public void onTestfailure(ITestResult rv) {
		test.log(Status.FAIL, MarkupHelper.createLabel("Method Failed", ExtentColor.RED));
		
		String s= new SimpleDateFormat("yyyyMMss hh:mm:ss").format(new Date());
		
		EventFiringWebDriver efw= new EventFiringWebDriver(BaseClass.driver);
		File f1 = efw.getScreenshotAs(OutputType.FILE);
		File f2 = new File("./screenshots/"+s+".png");
		try {
			FileUtils.copyFile(f1, f2);
			test.addScreenCaptureFromPath("./screenshots/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void onTestSkipped(ITestResult rv) {
		test.log(Status.SKIP, MarkupHelper.createLabel("Methos id skipped", ExtentColor.ORANGE));
	}
	


}
