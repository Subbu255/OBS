package com.banking.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.GenericUtility.WebDriverUtility;

public class Homepage {

	
	WebDriverUtility wut = new WebDriverUtility();
	
	
	
	@FindBy(linkText = "Open Account")
	private WebElement openAccountbtn;
	
	@FindBy(xpath = "//li[.='Apply Debit Card']")
	private WebElement applyDebitCardbtn;
	
	@FindBy(xpath =  "//a[contains(text(),'Internet Banking')]")
	private WebElement internetBankingbtn;
	
	@FindBy(xpath = "//li[text()='Fund Transfer']")
	private WebElement fundTransferbtn;
	
	@FindBy(linkText = "Home")
	private WebElement homebtn;
	
	@FindBy(xpath = "//a[.='Home']/../following-sibling::li/a[.='About Us']")
	private WebElement aboutUsbtn;
	
	@FindBy(xpath = "//a[.='Home']/../following-sibling::li/a[.='Contact Us']")
	private WebElement contactUsbtn;
	
	@FindBy(xpath = "//a[.='Home']/../following-sibling::li/a[.='Staff Login']")
	private WebElement staffLofinbtn;
	
	@FindBy(xpath = "//li[.='Register']")
	private WebElement internetBRegistrbtn;
	
	@FindBy(xpath = "//li[contains(text(),'Login')]")
	private WebElement internetBLoginbtn;
	
	
	public Homepage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}


	/**
	 * this method used to click on open account button
	 */
	public  void clickOpenAccountbtn(WebDriver driver) {
		// wut.waitForWebElement(driver,openAccountbtn, 20);
		openAccountbtn.click();;
	}


	/**
	 * this method used to click on apply debit card button
	 */
	public void clickApplyDebitCardbtn() {

		applyDebitCardbtn.click();
	}


	/**
	 * this method used to mouse cuser over to internetbanking button
	 */
	public void mouseOverToInternetBankingbtn(WebDriver driver) {

		wut.mouseOver(internetBankingbtn, driver);
	}


	/**
	 * this method used to click on fund transfer btn
	 */
	public void clickFundTransferbtn() {
		 fundTransferbtn.click();
	}


	/**
	 * this method used to click on home button
	 */
	public void clickHomebtn() {
		 homebtn.click();
	}



	public WebElement getAboutUsbtn() {
		return aboutUsbtn;
	}



	public WebElement getContactUsbtn() {
		return contactUsbtn;
	}


	/**
	 * this method used to click on staff login
	 */
	public void clickStaffLofinbtn() {
		 staffLofinbtn.click();
	}
	
	
	public void clickInternetBRegistrbtn() {
		
		internetBRegistrbtn.click();
	}
	
	public void clickInterBLogin(WebDriver driver) {
		
		wut.waitForWebElement(driver, internetBLoginbtn, 10);
		internetBLoginbtn.click();
		
	}
}
