package com.banking.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.GenericUtility.WebDriverUtility;

public class AddBeneficiarypage {

	
	@FindBy(name = "beneficiary_name")
	private WebElement beneficiaryNameTextfield;
	
	
	@FindBy(name = "beneficiary_acno")
	private WebElement beneficiaryAccNoTextfield;
	
	
	@FindBy(name = "Ifsc_code")
	private WebElement ifscCodeTextfield;
	
	@FindBy(name = "beneficiary_acc_type")
	private WebElement beneficiaryAccTypeDropdown;
	
	
	@FindBy(name = "add_beneficiary_btn")
	private WebElement addbtn;
	
	
	public AddBeneficiarypage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}


	public WebElement getBeneficiaryNameTextfield() {
		return beneficiaryNameTextfield;
	}


	public WebElement getBeneficiaryAccNoTextfield() {
		return beneficiaryAccNoTextfield;
	}


	public WebElement getIfscCodeTextfield() {
		return ifscCodeTextfield;
	}


	public WebElement getBeneficiaryAccTypeDropdown() {
		return beneficiaryAccTypeDropdown;
	}


	public WebElement getAddbtn() {
		return addbtn;
	}
	
	/**
	 * this method used for adding beneficiary
	 * @param name
	 * @param accNo
	 * @param ifscCode
	 */
	public void addBeneficiary(String name, String accNo, String ifscCode) {
		
		beneficiaryNameTextfield.sendKeys(name);
		beneficiaryAccNoTextfield.sendKeys(accNo);
		ifscCodeTextfield.sendKeys(ifscCode);
		
		WebDriverUtility wu = new WebDriverUtility();
		wu.dropdownSelectionByIndex(beneficiaryAccTypeDropdown, 1);
		
		addbtn.click();
	}
	
}
