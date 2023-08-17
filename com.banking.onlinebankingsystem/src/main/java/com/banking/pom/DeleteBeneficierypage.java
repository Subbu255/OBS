package com.banking.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteBeneficierypage {
	
	
	@FindBy(xpath = "//input[@name='radio']")
	private WebElement radiobtn;
	
	
	@FindBy(name = "delete_beneficiary")
	private WebElement deletebtn;
	
	
	public DeleteBeneficierypage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	/**
	 * this method used to delete beneficiery
	 * 
	 */
	public void deleteBeneficiery() {
		
		radiobtn.click();
		deletebtn.click();
		
		
		
	}
	
}
