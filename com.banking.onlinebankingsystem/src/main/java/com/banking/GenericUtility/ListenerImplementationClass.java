package com.banking.GenericUtility;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener{

	
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		Reporter.log(methodName+ "---testScript execution started ");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.generateLog(Status.PASS, methodName+"---> passed");
		Reporter.log(methodName+"-->testScript passed");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		
			File src = new File("./screenshot/abc.png");
			
			
		
		try {
			
			FileUtils.copyFile(new EventFiringWebDriver(BaseClass.sdriver).getScreenshotAs(OutputType.FILE), src);
			
		FileUtils.copyFile(new EventFiringWebDriver(BaseClass.sdriver).getScreenshotAs(OutputType.FILE), new File("./ScreenShot/"+methodName+".png"));
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		test.log(Status.FAIL, methodName+"---> failed");
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(src.getAbsolutePath(), methodName);
		Reporter.log(methodName+"-->testScript failed");
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"---> skiped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(methodName+"-->testScript skiped");
		
		
		
	}

	@Override
	public void onStart(ITestContext context) {

		
		
		ExtentSparkReporter htmlreports = new ExtentSparkReporter("./Reports/"+new Date().getHours()+".html");
		htmlreports.config().setDocumentTitle("OBS");
		htmlreports.config().setTheme(Theme.DARK);
		htmlreports.config().setReportName("Online Banking System");
		
		 report = new ExtentReports();
		report.attachReporter(htmlreports);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("Base-url", "http://rmgtestingserver/domain/Online_Banking_System");
		report.setSystemInfo("Reporter Name", "Subramani");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		report.flush();
	}
	
	
	
	
	

}
