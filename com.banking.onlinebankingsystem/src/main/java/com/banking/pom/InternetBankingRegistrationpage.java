package com.banking.pom;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.GenericUtility.ExcelFileUtility;

public class InternetBankingRegistrationpage {

	
	@FindBy(name = "holder_name")
	private WebElement holder_nameTextfield;
	
	
	@FindBy(name = "accnum")
	private WebElement accountNumberTextfield;
	
	
	@FindBy(name = "dbtcard")
	private WebElement debitCardNumberTextfield;
	
	
	@FindBy(name = "dbtpin")
	private WebElement debitCardPinTextfield;
	
	@FindBy(name = "mobile")
	private WebElement registeredMobileTextfield;
	
	@FindBy(name = "pan_no")
	private WebElement panNumberTextfield;
	
	
	@FindBy(name = "dob")
	private WebElement dateofBirthTextfield;
	
	@FindBy(name = "last_trans")
	private WebElement lasttTansTextfield;
	
	
	@FindBy(name = "password")
	private WebElement passwordTextfield;
	
	@FindBy(name = "cnfrm_password")
	private WebElement cnfrmPasswordTextfield;
	
	
	@FindBy(name = "submit")
	private WebElement submitbtn;
	
	
	public InternetBankingRegistrationpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * this method is used to register for internet banking
	 * @param name
	 * @param accNo
	 * @param debitCardNo
	 * @param debitCardPinNo
	 * @param regMobileNo
	 * @param panNo
	 * @param dateOfBirth
	 * @param lastTranstion
	 * @param creatPassword
	 * @param confmPassword
	 * @throws Throwable 
	 */
	public void internetBankingRegistration(String name, String accNo, String debitCardNo, String debitCardPinNo, String dateOfBirth, String creatPassword, String confmPassword) throws Throwable {
		
		
		ExcelFileUtility exutl = new ExcelFileUtility();
		HashMap<String, String> map = exutl.readDataFromExelFile("user details");

		String mobileNo = map.get("mobile no");
		
		// String dob = map.get("date of birth");
		
		String panNo = map.get("pan number");
		
		holder_nameTextfield.sendKeys(name);
		accountNumberTextfield.sendKeys(accNo);
		debitCardNumberTextfield.sendKeys(debitCardNo);
		debitCardPinTextfield.sendKeys(debitCardPinNo);
		registeredMobileTextfield.sendKeys(mobileNo);
		panNumberTextfield.sendKeys(panNo);
		dateofBirthTextfield.click();
		dateofBirthTextfield.sendKeys(dateOfBirth);
		lasttTansTextfield.sendKeys("0");
		passwordTextfield.sendKeys(creatPassword);
		cnfrmPasswordTextfield.sendKeys(confmPassword);
		submitbtn.click();
	}
	
}
