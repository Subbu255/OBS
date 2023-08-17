package com.banking.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewActioveCustomerpage {

	@FindBy(xpath = "//th[.='Username']/../following-sibling::tr[1]/td[2]")
	private WebElement userName;
	
	
	@FindBy(xpath = "//th[.='Username']/../following-sibling::tr[1]/td[4]")
	private WebElement accountNo;
	
	public ViewActioveCustomerpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	
	}

	public String getUserName() {
		return userName.getText();
	}

	public String getAccountNo() {
		return accountNo.getText();
	}
	
	
	
	
}
