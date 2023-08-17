package com.banking.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.banking.GenericUtility.JavaUtility;
import com.banking.GenericUtility.WebDriverUtility;

public class Confirmpage {
	
	WebDriver driver;
	WebDriverUtility wut = new WebDriverUtility();
	JavaUtility jut = new JavaUtility();
	
	//declaring the webelements (private)
	
	@FindBy(name = "cnfrm-submit")
	private WebElement cofirmbtn;
	
	@FindBy(xpath = "//input[@value='Go back']")
	private WebElement goBackbtn;
	
	public Confirmpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	/**
	 * this method is used to click on conformation button
	 */
	public void clickOnComfirmbtn() {
		
		cofirmbtn.click();
		
	}
	
	/**
	 * this method is used to verify the conformation msg popup
	 */
	public void verifyApplicationMsg() {
		
		wut.waitForAlertPopup(driver, 10);
		String popmsg = wut.getTextFromPopup(driver);
		Assert.assertTrue(popmsg.contains("successfully"), "user not able to apply");

	}
	
	
	/**
	 * this method is used to fetch the application number from conformation popup
	 * @return
	 */
	public String getApllicationNo() {
		
		wut.waitForAlertPopup(driver, 10);
		String popmsg = wut.getTextFromPopup(driver);
		String applicationNo = jut.getDigitNumberFromString(popmsg);
		System.out.println("applicationNo--->"+applicationNo);
		return applicationNo;
		
	}
	
	
	
/**
 * this method is used to accept application conformation popup	
 */
	public void acceptapplicationPopupMsg() {
		
		wut.acceptAlertPopup(driver);	
	}
}
