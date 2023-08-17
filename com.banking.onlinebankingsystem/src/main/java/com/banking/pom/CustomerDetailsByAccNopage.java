package com.banking.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerDetailsByAccNopage {
	
	
	@FindBy(name = "account_no")
	private WebElement accountNoTextfield;
	
	@FindBy(name = "submit_view")
	private WebElement submitbtn;
	
	
	public CustomerDetailsByAccNopage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	/**
	 * this method is used to get customer details by accountNo
	 * @param accountNo
	 */
	public void customerDetailsByAccNopage(String accountNo) {
		
		accountNoTextfield.sendKeys(accountNo);
		submitbtn.click();
		
	}
	
}
