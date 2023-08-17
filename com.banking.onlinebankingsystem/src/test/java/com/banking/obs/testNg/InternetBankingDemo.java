package com.banking.obs.testNg;

import org.testng.annotations.Test;

import com.banking.GenericUtility.BaseClass;

public class InternetBankingDemo extends BaseClass{

	
	@Test(priority = 0, groups = "smoke")
	public void registerForInternetBanking() {
		
		System.out.println("---register for internet banking ---");
		
	}
	
	
	@Test(priority = 2)
	public void loginToInternetBanking() {
		
		System.out.println("---login to internet banking ---");
		
	}
	
	
	@Test(priority = 3, groups = "smoke")
	public void addBeneficiery() {
		
		System.out.println("--- add beneficiery ---");
		
	}
	
	
	@Test(dependsOnMethods = "addBeneficiery", groups = "smoke")
	public void viewBeneficiery() {
		
		System.out.println("--- view beneficiery ---");
		
	}
	
	
	@Test(dependsOnMethods = "viewBeneficiery", groups = "smoke")
	public void deleteBeneficiery() {
		
		System.out.println("--- delete beneficiery ---");
		
	}
	
	@Test(dependsOnMethods = "deleteBeneficiery", groups = "smoke")
	public void fundsTransfer() {
		
		System.out.println("--- funds transfer ----");
	}
	
}
