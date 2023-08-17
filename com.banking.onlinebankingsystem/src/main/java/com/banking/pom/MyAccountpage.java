package com.banking.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountpage {

	
	@FindBy(xpath = "//span[.='Account Details']/following-sibling::label[contains(text(),'Account Number : ')]")
	private WebElement accountNobtext;
	
	@FindBy(name = "pass-chng")
	private WebElement changePasswordbtn;
	
	public MyAccountpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public String getaccountNobtext() {
		return accountNobtext.getText();
	}

	public void clickChangePasswordbtn() {
		changePasswordbtn.click();
	}
	
	
	
}
