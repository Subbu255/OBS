package com.banking.obs.testcases;



import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.banking.GenericUtility.BaseClass;
import com.banking.GenericUtility.ExcelFileUtility;
import com.banking.GenericUtility.JavaUtility;
import com.banking.GenericUtility.PropertyFileUtility;
import com.banking.GenericUtility.WebDriverUtility;
import com.banking.pom.ApplyDebitCardpage;
import com.banking.pom.ApprovePendingApplicationpage;
import com.banking.pom.Confirmpage;
import com.banking.pom.Homepage;
import com.banking.pom.RegistrationFormpage;
import com.banking.pom.StaffHomepage;
import com.banking.pom.StaffLoginpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplyingDebitCardTest {

	

	public static WebDriver driver;

	public static void main(String[] args) throws Throwable  {


		//creating object for utility classes

		JavaUtility jut = new JavaUtility();
		WebDriverUtility wut = new WebDriverUtility();
		PropertyFileUtility prutl = new PropertyFileUtility();
		ExcelFileUtility exutl = new ExcelFileUtility();


		int z1 = jut.getRandomNo(2023);
		int z2 = jut.getRandomNo(20);


		//lounching chromeBrowser 

		// WebDriverManager.chromedriver().setup();
		
		
		  System.setProperty("webdriver.chrome.driver",
		  "C:\\Users\\subra\\Downloads\\chromedriver_win32\\chromedriver.exe");
		  driver= new ChromeDriver(); 
		  driver.get(prutl.getPropertyData("url"));
		  
		  wut.maximizeBrowser(driver);
		

		//creating object for POM classes
		Homepage hp = new Homepage(driver);
		Confirmpage cfmp = new Confirmpage(driver);


		HashMap<String, String> map = exutl.readDataFromExelFile("user details");
		String name = map.get("name")+z2;

		RegistrationFormpage rstp = new RegistrationFormpage(driver);
		StaffLoginpage slp = new StaffLoginpage(driver);
		StaffHomepage shp = new StaffHomepage(driver);
		ApprovePendingApplicationpage ap = new ApprovePendingApplicationpage(driver);
		ApplyDebitCardpage adp = new ApplyDebitCardpage(driver);


		String dob =""+z2+"-01-"+z1+"";

		hp.clickOpenAccountbtn(driver);
		rstp.registrationSubmit(name, driver,dob);
		cfmp.clickOnComfirmbtn();

		wut.waitForAlertPopup(driver, 10);
		String popmsg = wut.getTextFromPopup(driver);
		wut.acceptAlertPopup(driver);

		String applicationNo = jut.getDigitNumberFromString(popmsg);

		System.out.println("applicationNo ---> "+applicationNo);

		//login has staff
		hp.clickStaffLofinbtn();
		slp.staffLogin();
		shp.clickApprovePendingAccountbtn();

		//giving approval 
		ap.approvePendingApplication(applicationNo);

		String accountPopmsg = wut.getTextFromPopup(driver);

		wut.acceptAlertPopup(driver);


		//getting account number from conformation pop up
		String accountNo = jut.getDigitNumberFromString(accountPopmsg);
		System.out.println("accountNo ---> "+accountNo);



		//applying debit card
		hp.clickHomebtn();
		hp.clickApplyDebitCardbtn();
		adp.applyDebitCard(name,dob, accountNo);

		String debitCardtPopmsg = wut.getTextFromPopup(driver);

		if(debitCardtPopmsg.contains("successfully")) {

			System.out.println("user can able to apply debit card  successfully");
		}
		else {

			System.out.println("user not able to apply debit card");
		}

		String Nobs = jut.getDigitNumberFromString(debitCardtPopmsg);
		wut.acceptAlertPopup(driver);
		
		String debitcardno = Nobs.substring(0,12);
		String pin = Nobs.substring(12, 16);
		System.out.println("debitcardno --->"+debitcardno+"");
		System.out.println("debit card pin --->"+pin+"");
	
	//
		driver.quit();
	}

}