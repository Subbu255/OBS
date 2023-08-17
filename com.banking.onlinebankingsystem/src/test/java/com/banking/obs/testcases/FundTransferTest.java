package com.banking.obs.testcases;

import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;

import com.banking.GenericUtility.ExcelFileUtility;
import com.banking.GenericUtility.JavaUtility;
import com.banking.GenericUtility.PropertyFileUtility;
import com.banking.GenericUtility.WebDriverUtility;
import com.banking.pom.AddBeneficiarypage;
import com.banking.pom.ApplyDebitCardpage;
import com.banking.pom.ApprovePendingApplicationpage;
import com.banking.pom.Confirmpage;
import com.banking.pom.CreditCustomerpage;
import com.banking.pom.FundTransferpage;
import com.banking.pom.Homepage;
import com.banking.pom.InternetBankingLoginpage;
import com.banking.pom.InternetBankingProfilepage;
import com.banking.pom.InternetBankingRegistrationpage;
import com.banking.pom.OtpVerificationpage;
import com.banking.pom.RegistrationFormpage;
import com.banking.pom.StaffHomepage;
import com.banking.pom.StaffLoginpage;
import com.banking.pom.ViewActioveCustomerpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FundTransferTest extends InternetBankingLoginTest {

	public static void main(String[] args) throws Throwable {


		//creating object for utility classes

		JavaUtility jut = new JavaUtility();
		WebDriverUtility wut = new WebDriverUtility();
		PropertyFileUtility prutl = new PropertyFileUtility();
		ExcelFileUtility exutl = new ExcelFileUtility();


		int z1 = jut.getRandomNo(2023);
		int z2 = jut.getRandomNo(20);


		//lounching chromeBrowser 

		//WebDriverManager.chromedriver().setup();

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

		shp.clickStaffHomebtn();
		shp.clickViewActiveCustomerbtn();
		ViewActioveCustomerpage vac = new ViewActioveCustomerpage(driver);
		String accountNo1 = vac.getAccountNo();
		String name1 = vac.getUserName();

		//getting account number from conformation pop up
		String accountNo = jut.getDigitNumberFromString(accountPopmsg);
		System.out.println("accountNo ---> "+accountNo);

		shp.clickStaffHomebtn();
		shp.clickCreditCustomerbtn();

		CreditCustomerpage ccp = new CreditCustomerpage(driver);
		ccp.creditCustomerpage(accountNo, "10000");
		wut.waitForAlertPopup(driver, 10);
		wut.acceptAlertPopup(driver);

		//applying debit card
		hp.clickHomebtn();
		hp.clickApplyDebitCardbtn();
		adp.applyDebitCard(name,dob, accountNo);

		wut.waitForAlertPopup(driver, 10);
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

		wut.waitForAlertPopup(driver, 10);

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
		inbpp.clickFundTransferbtn();

		FundTransferpage ftrp = new FundTransferpage(driver);
		ftrp.clickAddBeneficiarybtn();



		String ifscCode = "1011";
		AddBeneficiarypage abp = new AddBeneficiarypage(driver);
		abp.addBeneficiary(name1, accountNo1, ifscCode);
		wut.waitForAlertPopup(driver, 10);
		wut.acceptAlertPopup(driver);
		
		inbpp.clickFundTransferbtn();
		ftrp.fundTransfer("5000", "not real");
		
		OtpVerificationpage otp = new OtpVerificationpage(driver);
		String ot= otp.getOtp();

		
		
		String o = jut.getDigitNumberFromString(ot);
		String t = o.substring(10, 16);
		
		otp.verifyOtp(t);
		wut.waitForAlertPopup(driver, 10);
		String msg = wut.getTextFromPopup(driver);
		
		wut.acceptAlertPopup(driver);
		inbpp.clickFundTransferbtn();
		
		driver.quit();
		
		if(msg.contains("Successful!"))
		{
		
			System.out.println("User can able to Transfer funds Successful!");
		}
		else
		{
			System.out.println("User not able to Transfer funds ");
		}
		
		


	}

	
}
