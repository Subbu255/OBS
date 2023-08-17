package com.banking.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.GenericUtility.JavaUtility;
import com.banking.GenericUtility.WebDriverUtility;

public class ApprovePendingApplicationpage {
	
	WebDriver driver;
	WebDriverUtility wut = new WebDriverUtility();
	JavaUtility jut = new  JavaUtility();
	
	@FindBy(name = "application_no")
	private WebElement application_noTextfield;
	
	@FindBy(name = "search_application")
	private WebElement search_btn;
	
	
	@FindBy(name = "approve_cust")
	private WebElement approve_cust_btn;
	
	
	public ApprovePendingApplicationpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/**
	 * this method is used to search the application number and approving 
	 * @param applicationNo
	 * @throws InterruptedException
	 */
	public void approvePendingApplication(String applicationNo) throws InterruptedException {
		
		application_noTextfield.sendKeys(applicationNo);
		search_btn.click();
		approve_cust_btn.click();
		
	}
	
	/**
	 * this method is used to fetch account number from popup
	 * @return
	 */
	public String getAccountNo() {
		String accountPopmsg = wut.getTextFromPopup(driver);
		
		String accountNo = jut.getDigitNumberFromString(accountPopmsg);
		System.out.println("accountNo ---> "+accountNo);
		return accountNo;
	}
	
}
