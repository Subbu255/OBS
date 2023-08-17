package com.banking.obs.testcases;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.banking.GenericUtility.ExcelFileUtility;
import com.banking.GenericUtility.JavaUtility;
import com.banking.GenericUtility.PropertyFileUtility;
import com.banking.GenericUtility.WebDriverUtility;
import com.banking.pom.ApplyDebitCardpage;
import com.banking.pom.ApprovePendingApplicationpage;
import com.banking.pom.Confirmpage;
import com.banking.pom.Homepage;
import com.banking.pom.InternetBankingLoginpage;
import com.banking.pom.InternetBankingProfilepage;
import com.banking.pom.InternetBankingRegistrationpage;
import com.banking.pom.RegistrationFormpage;
import com.banking.pom.StaffHomepage;
import com.banking.pom.StaffLoginpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InternetBankingLoginTest extends ApplyingDebitCardTest {

	public static void main(String[] args) throws Throwable {
		
		

		//creating object for utility classes

		JavaUtility jut = new JavaUtility();
		WebDriverUtility wut = new WebDriverUtility();
		PropertyFileUtility prutl = new PropertyFileUtility();
		ExcelFileUtility exutl = new ExcelFileUtility();


		int z1 = jut.getRandomNo(1000);
		int z2 = jut.getRandomNo(20);


		//lounching chromeBrowser 

		// WebDriverManager.chromedriver().setup();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\subra\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
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
		rstp.registrationSubmit(name, driver, dob);
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
		
		String Nobs = jut.getDigitNumberFromString(debitCardtPopmsg);
		wut.acceptAlertPopup(driver);
		hp.clickHomebtn();

		String debitcardno = Nobs.substring(0,12);
		String pin = Nobs.substring(12, 16);		
		
		hp.mouseOverToInternetBankingbtn(driver);
		hp.clickInternetBRegistrbtn();
		
		InternetBankingRegistrationpage inrp = new InternetBankingRegistrationpage(driver);
		
		String password = "abc@1123";
		
		inrp.internetBankingRegistration(name, accountNo, debitcardno, pin, dob, password, password);
		
		String internetRegtPopmsg = wut.getTextFromPopup(driver);
		
		String customerId = jut.getDigitNumberFromString(internetRegtPopmsg);
		wut.acceptAlertPopup(driver);
		
		System.out.println("customerId ---> "+ customerId);
		
		hp.clickHomebtn();
		hp.mouseOverToInternetBankingbtn(driver);
		hp.clickInterBLogin(driver);
		
		InternetBankingLoginpage inlp = new InternetBankingLoginpage(driver);
		inlp.loginInternetBanking(customerId, password);
		
		InternetBankingProfilepage inbpp = new InternetBankingProfilepage(driver);
		String text = inbpp.getWelcomeText();
		
		driver.quit();
		if(text.contains(name)) {
		System.out.println("user successfully loged in to internet banking");
	
		}
		else
		{
			System.out.println("user not able login to internet banking");
		}
		}

}
