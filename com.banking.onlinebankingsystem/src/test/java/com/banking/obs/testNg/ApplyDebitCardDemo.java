package com.banking.obs.testNg;

import org.testng.annotations.Test;

import com.banking.GenericUtility.BaseClass;

public class ApplyDebitCardDemo extends BaseClass {
	
	
	
	@Test
	public void applyDebitcard() {
		
		System.out.println("----apply debit card ----");
	}
	
	@Test(groups = "smoke")
	public void approveDebitcard() {
		
		System.out.println("---approve debit card ----");
		
	}
	
	
	@Test(groups = "regretion")
	public void deactiveteDebitcard() {
		
		System.out.println("---deactivate debit card ----");
	}
	
	
	@Test
	public void reapplyForDebitcard() {
		
		System.out.println("--re applying for debit card ----");
	}

}
