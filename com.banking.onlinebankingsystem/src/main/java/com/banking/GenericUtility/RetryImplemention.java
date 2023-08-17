package com.banking.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplemention implements IRetryAnalyzer {

	
	int count =0;
	int retryCount = 5;
	
	@Override
	public boolean retry(ITestResult result) {

		if(count<retryCount)
		{
			count++;
			return true;
		}
		return false;
	}

	
	
	
	
	
}
