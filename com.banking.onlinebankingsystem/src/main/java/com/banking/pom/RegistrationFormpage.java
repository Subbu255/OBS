package com.banking.pom;

import com.banking.GenericUtility.*;

import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.GenericUtility.WebDriverUtility;

public class RegistrationFormpage {

	WebDriver driver;
	
	@FindBy(name = "name")
	private WebElement nameTextfield;

	@FindBy(name = "gender")
	private WebElement genderDropdown;

	@FindBy(name = "mobile")
	private WebElement mobileTextfield;

	@FindBy(name = "email")
	private WebElement emailTextfield;

	@FindBy(name = "landline")
	private WebElement landlineTextfield;

	@FindBy(name = "dob")
	private WebElement dateOfBirthTextfield;


	@FindBy(name = "pan_no")
	private WebElement panNoTextfield;

	@FindBy(name = "citizenship")
	private WebElement citizenshipTextfield;

	@FindBy(name = "homeaddrs")
	private WebElement homeaddrsTextfield;

	@FindBy(name = "officeaddrs")
	private WebElement officeaddrsTextfield;

	@FindBy(name = "state")
	private WebElement stateDropDwon;

	@FindBy(name = "city")
	private WebElement cityDropDwon;
	
	@FindBy(name = "pin")
	private WebElement pinCodeTextfield;

	@FindBy(name = "arealoc")
	private WebElement arealocTextfield;

	@FindBy(name = "nominee_name")
	private WebElement nominee_nameTextfield;

	@FindBy(name = "nominee_ac_no")
	private WebElement nominee_ac_noTextfield;

	@FindBy(name = "acctype")
	private WebElement acctypeDropDown;

	@FindBy(name = "submit")
	private WebElement submitbtn;


	public RegistrationFormpage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}


	public WebElement getNameTextfield() {
		return nameTextfield;
	}


	public WebElement getGenderDropdown() {
		return genderDropdown;
	}


	public WebElement getMobileTextfield() {
		return mobileTextfield;
	}


	public WebElement getEmailTextfield() {
		return emailTextfield;
	}


	public WebElement getLandlineTextfield() {
		return landlineTextfield;
	}


	public WebElement getDateOfBirthTextfield() {
		return dateOfBirthTextfield;
	}


	public WebElement getCitizenshipTextfield() {
		return citizenshipTextfield;
	}


	public WebElement getHomeaddrsTextfield() {
		return homeaddrsTextfield;
	}


	public WebElement getOfficeaddrsTextfield() {
		return officeaddrsTextfield;
	}


	public WebElement getStateDropDwon() {
		return stateDropDwon;
	}


	public WebElement getCityDropDwon() {
		return cityDropDwon;
	}


	public WebElement getArealocTextfield() {
		return arealocTextfield;
	}


	public WebElement getNominee_nameTextfield() {
		return nominee_nameTextfield;
	}


	public WebElement getNominee_ac_noTextfield() {
		return nominee_ac_noTextfield;
	}


	public WebElement getAcctypeDropDown() {
		return acctypeDropDown;
	}


	public WebElement getSubmitbtn() {
		return submitbtn;
	}





	/**
	 * this method is for registering account	
 
	 */
	public void registrationSubmit(String name, WebDriver driver, String dob) throws Throwable {
		
		WebDriverUtility wb = new WebDriverUtility();
		ExcelFileUtility exutl = new ExcelFileUtility();
		HashMap<String, String> map = exutl.readDataFromExelFile("user details");
		
		JavaUtility jut = new JavaUtility();
		int z1 = jut.getRandomNo(2023);
		int z2 = jut.getRandomNo(20);

		
		
		
		String gender = map.get("gender");
		String mobileNo = map.get("mobile no");
		String emailId = map.get("email id");
		String landlineNo = map.get("landline");
				
		String panNo = map.get("pan number");
		String citizenshipNo = map.get("citizevship number");
		String homeaddres = map.get("home address");
		String officeaddres = map.get("office address");
		String state = map.get("state");
		String indexOfCity = map.get("city");
		String area = map.get("area");
		String pinCode = map.get("pin code");
		String nomineeName = map.get("nominee name");
		String nomineeAccNo = map.get("nominee no");
		String accType = map.get("account type");
		
		nameTextfield.sendKeys(name);

		//create object for webdriver utility class and use drop down method to select gender
	
		wb.dropdownSelectionByVisibleText(genderDropdown, gender);

		mobileTextfield.sendKeys(mobileNo);
		emailTextfield.sendKeys(emailId);
		landlineTextfield.sendKeys(landlineNo);
		
		dateOfBirthTextfield.click();
		dateOfBirthTextfield.sendKeys(dob);
		citizenshipTextfield.sendKeys(citizenshipNo);
		panNoTextfield.sendKeys(panNo);
		pinCodeTextfield.sendKeys(pinCode);
		homeaddrsTextfield.sendKeys(homeaddres);
		officeaddrsTextfield.sendKeys(officeaddres);

		wb.dropdownSelectionByVisibleText(stateDropDwon, state);
		
		wb.dropdownSelectionByVisibleText(cityDropDwon, indexOfCity);

		arealocTextfield.sendKeys(area);
		nominee_nameTextfield.sendKeys(nomineeName);
		nominee_ac_noTextfield.sendKeys(nomineeAccNo);

		wb.dropdownSelectionByVisibleText(acctypeDropDown, accType);

		submitbtn.click();

	}



}
