package com.banking.obs.testNg;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Listeners;
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

@Listeners(com.banking.GenericUtility.ListenerImplementationClass.class)
public class ApplyDebitCardTest extends BaseClass {
	
	@Test(retryAnalyzer = com.banking.GenericUtility.RetryImplemention.class)
	public void applyDebitCardTest() throws Throwable  {

		
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
	
	String applicationNo = cfmp.getApllicationNo();
	
	cfmp.acceptapplicationPopupMsg();
	  		
	hp.clickStaffLofinbtn();
	slp.staffLogin();
	shp.clickApprovePendingAccountbtn();
	ap.approvePendingApplication(applicationNo);

	String accountPopmsg = wut.getTextFromPopup(driver);

	//getting account number from conformation pop up
	
	String accountNo = jut.getDigitNumberFromString(accountPopmsg);
	
	System.out.println("applicationNo--->"+applicationNo);
	
	System.out.println("accountNo--->"+accountNo);
	
	wut.acceptAlertPopup(driver);

	hp.clickHomebtn();
	hp.clickApplyDebitCardbtn();
	
	adp.applyDebitCard(name,dob, accountNo);
	adp.verifyPopupMsg();
	adp.getDebitCardNO();
	adp.getDebitCardpin();
	adp.acceptDebitCardPopup();
	
	}
}