package com.banking.GenericUtility;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {

	WebDriver driver;
	/**
	 * this method is used to maximize the browser
	 */
	public void maximizeBrowser(WebDriver driver) {

		driver.manage().window().maximize();

	}

	/**
	 * this method is used to wait for findelement or findelements methods
	 * @param duration
	 */
	public void pageLoadWait(int duration) {

		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
	}

	/**
	 * this method is used to wait for a alert 
	 * @param duration
	 */
	public void waitForAlertPopup(WebDriver driver, int duration) {

		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.alertIsPresent());

	}

	/**
	 *this method is used to wait for a perticular webElement locator 
	 * @param elementLocator
	 * @param duration
	 */
	public void waitForWebElement(WebDriver driver, WebElement element,int duration) {

		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * this method is used to select drop down options by visible text 
	 * @param targetElement
	 * @param visibleText
	 */
	public void dropdownSelectionByVisibleText(WebElement targetElement, String visibleText) {

		Select s = new Select(targetElement);
		s.selectByVisibleText(visibleText);
	}


	/**
	 * this method is used to select drop down options by index 
	 * @param targetElement
	 * @param visibleText
	 */
	public void dropdownSelectionByIndex(WebElement targetElement, int index) {

		Select s = new Select(targetElement);
		s.selectByIndex(index);
	}


	/**
	 * this method is used to mouse over to perticular element
	 * @param targetElement
	 */
	public void mouseOver(WebElement targetElement,WebDriver driver) {

		Actions a = new Actions(driver);
		a.moveToElement(targetElement);
		a.perform();
	}

	/**
	 * this method is used to double click on default location
	 */
	public void doubleClick(WebDriver driver) {

		Actions a = new Actions(driver);
		a.doubleClick();
	}


	/**
	 * this method is used to double click on targeted webElement
	 */
	public void doubleClick(WebElement targetElement, WebDriver driver) {

		Actions a = new Actions(driver);
		a.doubleClick(targetElement);
	}

	/**
	 * this method is used to get text from popup
	 * @return
	 */
	public String getTextFromPopup(WebDriver driver) {

		Alert a = driver.switchTo().alert();
		
		return a.getText();
		
	}


	/**
	 * this method is used to accept the alert
	 */
	public void acceptAlertPopup(WebDriver driver) {

		Alert a = driver.switchTo().alert();
		a.accept();
	}

	/**
	 * this method is used to take screen shot 
	 */
	public void takeScreenshot(WebDriver driver) {

		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("");

	}

}


