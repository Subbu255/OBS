package com.banking.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetBankingLoginpage {
	
	
	@FindBy(name = "customer_id")
	private WebElement customeridTextfield;
	
	
	@FindBy(name = "password")
	private WebElement passwordTextField;
	
	@FindBy(name = "login-btn")
	private WebElement loginbtn;
	
	
	@FindBy(xpath = "//a[.='FORGET PASSWORD ?']")
	private WebElement forgetPasswordLink;
	
	

	public InternetBankingLoginpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	/**
	 * this method is used to login internet banking
	 * @param customerId
	 * @param password
	 */
	public void loginInternetBanking(String customerId, String password) {
		
		customeridTextfield.sendKeys(customerId);
		passwordTextField.sendKeys(password);
		loginbtn.click();
		
	}
	
}
