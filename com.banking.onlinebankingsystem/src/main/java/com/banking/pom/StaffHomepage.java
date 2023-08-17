package com.banking.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffHomepage {
	
	
	@FindBy(name = "viewdet")
	private WebElement viewActiveCustomerbtn;
	
	@FindBy(name = "view_cust_by_ac")
	private WebElement viewCustomerByAccNobtn;
	
	@FindBy(name = "apprvac")
	private WebElement approvePendingAccountbtn;
	
	@FindBy(name = "del_cust")
	private WebElement deleteCustomerAccbtn;
	
	@FindBy(name = "credit_cust_ac")
	private WebElement creditCustomerbtn;
	
	@FindBy(xpath = "//input[@name=\"home\"]")
	private WebElement staffHomebtn;
	
	@FindBy(xpath = "//input[@name=\"logout_btn\"]")
	private WebElement staffLogoutbtn;
	
	
	public StaffHomepage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}


	public void clickViewActiveCustomerbtn() {
		viewActiveCustomerbtn.click();
		
	}


	public WebElement getViewCustomerByAccNobtn() {
		return viewCustomerByAccNobtn;
	}


	public void clickApprovePendingAccountbtn() {
		approvePendingAccountbtn.click();
	}


	public void clickDeleteCustomerAccbtn() {
		deleteCustomerAccbtn.click();
	}


	public void clickCreditCustomerbtn() {
		creditCustomerbtn.click();
	}


	public void clickStaffHomebtn() {
	 staffHomebtn.click();
	}


	public void clickStaffLogoutbtn() {
		staffLogoutbtn.click();
	}
	
	
	
	
	

}
