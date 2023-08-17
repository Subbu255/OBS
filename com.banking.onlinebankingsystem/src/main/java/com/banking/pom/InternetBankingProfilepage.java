package com.banking.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetBankingProfilepage {
	
	
	@FindBy(xpath = "//li[.='My Account']")
	private WebElement myAccountbtn;
	
	@FindBy(xpath = "//li[.='My Profile']")
	private WebElement myProfilebtn;
	
	
	@FindBy(xpath = "//li[.='Change Password']")
	private WebElement changePasswordbtn;
	
	
	@FindBy(xpath = "//li[.='Fund Transfer']")
	private WebElement fundTransferbtn;
	
	
	@FindBy(xpath = "//li[.='Statement']")
	private WebElement statementbtn;
	
	
	@FindBy(name = "logout_btn")
	private WebElement intnetLogoutbtn;
	
	@FindBy(xpath = "//input[@name='home']")
	private WebElement internetBanHomebtn;
	
	
	@FindBy(xpath = "//div[@class='welcome']/label")
	private WebElement welcomeText;
	
	public InternetBankingProfilepage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public void clickMyAccountbtn() {
		myAccountbtn.click();
	}

	public void clickMyProfilebtn() {
		myProfilebtn.click();
	}

	public void clickChangePasswordbtn() {
		changePasswordbtn.click();
	}

	public void clickFundTransferbtn() {
		fundTransferbtn.click();
	}

	public void clickStatementbtn() {
		statementbtn.click();
	}

	public void clickIntnetLogoutbtn() {
		intnetLogoutbtn.click();
	}

	public void clickInternetBanHomebtn() {
		internetBanHomebtn.click();
	}

	public String getWelcomeText() {
		
		
		return welcomeText.getText();
	}
	
	
	

}
