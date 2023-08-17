package com.banking.GenericUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.banking.pom.Homepage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass{

	public WebDriver driver;
	public static WebDriver sdriver;
	
	public JavaUtility jut = new JavaUtility();
	public WebDriverUtility wut = new WebDriverUtility();
	public PropertyFileUtility prutl = new PropertyFileUtility();
	public ExcelFileUtility exutl = new ExcelFileUtility();
	

	public int z1 = jut.getRandomNo(2023);
	public int z2 = jut.getRandomNo(20);

	
	@BeforeSuite
	public void config_BS() {


		System.out.println("--opening data base---");

	}

	@AfterSuite
	public void config_AS() {
		
		

		System.out.println("-- close the data base");
	}

	@BeforeClass(alwaysRun = true)
	public void config_BC() throws Throwable {

		//lounching chromeBrowser 

	   // 	WebDriverManager.chromedriver().setup();
		 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\subra\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		  driver = new ChromeDriver(); 
		   
		  sdriver = driver;
		  wut.maximizeBrowser(driver);
		
		System.out.println("--open browser --");
	}

	@AfterClass(alwaysRun = true)
	public void config_AC() {

		//driver.quit();
		
		System.out.println("--close browser--");
	}

	@BeforeMethod(alwaysRun = true)
	public void config_BM() {

		System.out.println("--login to application --");
	}

	@AfterMethod(alwaysRun = true)
	public void config_AM() {

		System.out.println("-- logout from the application --");
	}


}
