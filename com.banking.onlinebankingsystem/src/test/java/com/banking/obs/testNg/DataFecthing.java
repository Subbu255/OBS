package com.banking.obs.testNg;

import org.testng.annotations.Test;

public class DataFecthing {
	
	
	
	@Test(dataProviderClass = DataProvide.class,dataProvider = "data")
	public void fecthingDAta(String name, long mobileNo) {
		
		System.out.println("name--->"+name+"mobile no--->"+mobileNo);
	}

	
	
	
	
	
	
}
