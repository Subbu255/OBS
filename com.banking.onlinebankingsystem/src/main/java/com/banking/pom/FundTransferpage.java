package com.banking.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.GenericUtility.WebDriverUtility;

public class FundTransferpage {
	
	
	@FindBy(name = "add_beneficiary")
	private WebElement addBeneficiarybtn;
	
	
	@FindBy(name = "delete_beneficiary")
	private WebElement deleteBeneficiarybtn;
	
	@FindBy(name = "beneficiary")
	private WebElement selectBeneficiarydropdown;
	
	@FindBy(name = "trnsf_amount")
	private WebElement trnsfAmountTextfield;
	
	
	@FindBy(name = "trnsf_remark")
	private WebElement remarkTextfield;
	
	
	
	@FindBy(name = "fnd_trns_btn")
	private WebElement fundTransSendbtn;
	
	
	
	@FindBy(name = "view_beneficiary")
	private WebElement viewBeneficiarybtn;
	
	
	public FundTransferpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}


	public void clickAddBeneficiarybtn() {
		addBeneficiarybtn.click();
	}


	public void clickDeleteBeneficiarybtn() {
		deleteBeneficiarybtn.click();
	}


	public WebElement getSelectBeneficiarydropdown() {
		return selectBeneficiarydropdown;
	}


	public WebElement getTrnsfAmountTextfield() {
		return trnsfAmountTextfield;
	}


	public WebElement getRemarkTextfield() {
		return remarkTextfield;
	}


	public WebElement FundTransSendbtn() {
		return fundTransSendbtn;
	}

	public void clickViewBeneficiarybtn() {
		viewBeneficiarybtn.click();
	}
	
	public void fundTransfer( String amount, String remarks) {
		
		WebDriverUtility wu = new WebDriverUtility();
		wu.dropdownSelectionByIndex(selectBeneficiarydropdown, 1);
		trnsfAmountTextfield.sendKeys(amount);
		remarkTextfield.sendKeys(remarks);
		fundTransSendbtn.click();
		
	}
	
}
