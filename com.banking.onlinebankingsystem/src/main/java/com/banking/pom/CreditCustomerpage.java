package com.banking.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCustomerpage {
	
	
	@FindBy(name = "customer_account_no")
	private WebElement customer_account_noTextfield;
	
	
	@FindBy(name = "credit_amount")
	private WebElement credit_amountnoTextfield;
	
	
	@FindBy(name = "credit_btn")
	private WebElement credit_btn;
	
	public CreditCustomerpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * this method is used to credit amount to perticular account number
	 * @param accNo
	 * @param amount
	 */
	public void creditCustomerpage(String accNo, String amount) {
		
		customer_account_noTextfield.sendKeys(accNo);
		credit_amountnoTextfield.sendKeys(amount);
		credit_btn.click();
		
	}
	
}
