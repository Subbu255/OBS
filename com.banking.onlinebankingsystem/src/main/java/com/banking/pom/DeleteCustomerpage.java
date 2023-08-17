package com.banking.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerpage {

	
	@FindBy(name = "Cust_ac_no")
	private WebElement custAccNo_Textfield;
	
	@FindBy(name = "Cust_ac_Id")
	private WebElement custId_Textfield;
	
	@FindBy(name = "reason")
	private WebElement reason_Textfield;
	
	@FindBy(name = "delete")
	private WebElement delete_btn;
	
	@FindBy(name = "home")
	private WebElement staffHome_btn;
	
	@FindBy(name = "logout_btn")
	private WebElement logout_btn;
	
	public DeleteCustomerpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * this method is used to delete perticular account
	 * @param accNo
	 * @param custId
	 * @param reason
	 */
	public void deleteCustomerpage(String accNo, String custId, String reason) {
		custAccNo_Textfield.sendKeys(accNo);
		custId_Textfield.sendKeys(custId);
		reason_Textfield.sendKeys(reason);
		delete_btn.click();
	}
	
}
