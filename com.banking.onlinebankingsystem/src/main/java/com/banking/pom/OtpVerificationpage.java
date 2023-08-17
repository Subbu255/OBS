package com.banking.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OtpVerificationpage {

	@FindBy(xpath = "//label[@class=\"OTP_msg\"]")
	private WebElement otpMsgText;
	
	
	@FindBy(xpath = "//input[@name='otpcode']")
	private WebElement otpTextfield;
	
	@FindBy(xpath = "//input[@name='verify-btn']")
	private WebElement verifybtn;
	
	public OtpVerificationpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void verifyOtp(String otp) {
		
		otpTextfield.sendKeys(otp);
		verifybtn.click();
		
	}
	
	public String getOtp() {
		
		return otpMsgText.getText();
		
	}
	
}
