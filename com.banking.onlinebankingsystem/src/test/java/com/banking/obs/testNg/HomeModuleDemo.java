package com.banking.obs.testNg;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.banking.GenericUtility.BaseClass;
import com.banking.GenericUtility.ExcelFileUtility;
import com.banking.pom.ApplyDebitCardpage;
import com.banking.pom.ApprovePendingApplicationpage;
import com.banking.pom.Confirmpage;
import com.banking.pom.Homepage;
import com.banking.pom.RegistrationFormpage;
import com.banking.pom.StaffHomepage;
import com.banking.pom.StaffLoginpage;

public class HomeModuleDemo extends BaseClass {
	
	
	 RegistrationFormpage rp = new RegistrationFormpage(driver);
	
	@Test	
	public void openAccount() throws Throwable  {

		
		String dob =""+z2+"-01-"+z1+"";
		
		 driver.get(prutl.getPropertyData("url"));
	Homepage hp = new Homepage(driver);

	RegistrationFormpage rp = new RegistrationFormpage(driver);
	Confirmpage cfmp = new Confirmpage(driver);
	StaffLoginpage slp = new StaffLoginpage(driver);
	StaffHomepage shp = new StaffHomepage(driver);
	ApprovePendingApplicationpage ap = new ApprovePendingApplicationpage(driver);
	ApplyDebitCardpage adp = new ApplyDebitCardpage(driver);
	ExcelFileUtility exutl = new ExcelFileUtility();
	HashMap<String, String> map = exutl.readDataFromExelFile("user details");
	
	
	hp.clickOpenAccountbtn(driver);
	
	String name = map.get("name")+z2;
	
	rp.registrationSubmit(name,driver, dob);
	cfmp.clickOnComfirmbtn();
	
	wut.waitForAlertPopup(driver, 10);
	String popmsg = wut.getTextFromPopup(driver);
	wut.acceptAlertPopup(driver);

	String applicationNo = jut.getDigitNumberFromString(popmsg);
	
	hp.clickStaffLofinbtn();
	slp.staffLogin();
	shp.clickApprovePendingAccountbtn();
	ap.approvePendingApplication(applicationNo);
	
	String accountPopmsg = wut.getTextFromPopup(driver);

	wut.acceptAlertPopup(driver);


	//getting account number from conformation pop up
	
	String accountNo = jut.getDigitNumberFromString(accountPopmsg);
	
	System.out.println("applicationNo--->"+applicationNo);
	
	System.out.println("accountNo--->"+accountNo);
	
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
	
	
	}
	
}
