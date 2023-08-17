package com.banking.pom;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.banking.GenericUtility.ExcelFileUtility;
import com.banking.GenericUtility.JavaUtility;
import com.banking.GenericUtility.WebDriverUtility;

public class ApplyDebitCardpage {

	WebDriver driver;
	
	WebDriverUtility wut = new WebDriverUtility();
	JavaUtility jut = new JavaUtility();
	
	
	@FindBy(name = "holder_name")
	private WebElement holder_nameTextfield;
	
	@FindBy(name = "dob")
	private WebElement dateOfBirthTextfield;
	
	@FindBy(name = "pan")
	private WebElement panNoTextfield;
	
	
	@FindBy(name = "mob")
	private WebElement regMobileNoTextfield;
	
	
	@FindBy(name = "acc_no")
	private WebElement acc_noTextfield;
	
	
	@FindBy(name = "dbt_crd_submit")
	private WebElement submitbtn;
	
	
	public ApplyDebitCardpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
	
	}


	public WebElement getHolder_nameTextfield() {
		return holder_nameTextfield;
	}


	public WebElement getDateOfBirthTextfield() {
		return dateOfBirthTextfield;
	}


	public WebElement getPanNoTextfield() {
		return panNoTextfield;
	}


	public WebElement getRegMobileNoTextfield() {
		return regMobileNoTextfield;
	}


	public WebElement getAcc_noTextfield() {
		return acc_noTextfield;
	}


	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	/**
	 * this method is used to apply debit card
	 * @param name
	 * @param dateOfBirth
	 * @param accountNo
	 * @throws Throwable 
	 */
	public void applyDebitCard(String name, String dob, String accountNo) throws Throwable {
		
		ExcelFileUtility exutl = new ExcelFileUtility();
		HashMap<String, String> map = exutl.readDataFromExelFile("user details");
		 
		String regMobileNo = map.get("mobile no");
		
		//String dob = map.get("date of birth");
		
		String panCardNo = map.get("pan number");
		
	
		
		holder_nameTextfield.sendKeys(name);
		
		  
		
		  dateOfBirthTextfield.click();
		dateOfBirthTextfield.sendKeys(dob);
		panNoTextfield.sendKeys(panCardNo);
		regMobileNoTextfield.sendKeys(regMobileNo);
		acc_noTextfield.sendKeys(accountNo);
		submitbtn.click();
		
	}

	/**
	 * this method is used to verify the debit card popup msg
	 * @param driver
	 */
	public void verifyPopupMsg() {
		
		
		String debitCardtPopmsg = wut.getTextFromPopup(driver);
	
		Assert.assertTrue(debitCardtPopmsg.contains("successfully"));

		System.out.println("user can able to apply debit card  successfully");
		
	}
	
	
	/**
	 * this method is used to get debit number from popup msg
	 * @param driver
	 * @return
	 */
	public String getDebitCardNO() {
		
		String debitCardtPopmsg = wut.getTextFromPopup(driver);
		
		String Nobs = jut.getDigitNumberFromString(debitCardtPopmsg);
		String debitCardNo = Nobs.substring(0,12);

		System.out.println("debitCardNo --->"+debitCardNo+"");
		return debitCardNo;
	}
	
	/**
	 * this method is used to get debit card pin from popup msg
	 * @param driver
	 * @return
	 */
	public String getDebitCardpin() {
		
		String debitCardtPopmsg = wut.getTextFromPopup(driver);
		
		String Nobs = jut.getDigitNumberFromString(debitCardtPopmsg);

		String debitCardPin = Nobs.substring(12, 16);
		
		System.out.println("DebitCardpin --->"+debitCardPin+"");
	
		return debitCardPin;
	}
	
	/**
	 * this method is used to accept debit card popup msg
	 * @param driver
	 */
	public void acceptDebitCardPopup() {
	
	wut.acceptAlertPopup(driver);
	
}
	
}
