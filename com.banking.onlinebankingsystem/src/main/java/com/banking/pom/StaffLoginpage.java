package com.banking.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.GenericUtility.PropertyFileUtility;

public class StaffLoginpage {
	
	
	@FindBy(name = "staff_id")
	private WebElement staffIdTextField;
	
	@FindBy(name = "password")
	private WebElement passwordTextField;
	
	@FindBy(name = "staff_login-btn")
	private WebElement staffLoginbtn;
	
	/**
	 * this constructor is used to load the webelements
	 * @param driver
	 */
	public StaffLoginpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * this method is used for staff login
	 * @param staffid
	 * @param password
	 * @throws Throwable 
	 */
	public void staffLogin() throws Throwable {
		
		PropertyFileUtility p = new PropertyFileUtility();
		staffIdTextField.sendKeys(p.getPropertyData("username"));
		passwordTextField.sendKeys(p.getPropertyData("password"));
		staffLoginbtn.click();
	}
	
}
