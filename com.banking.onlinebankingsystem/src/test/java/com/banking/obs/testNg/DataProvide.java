package com.banking.obs.testNg;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.GenericUtility.IPathConstants;

public class DataProvide {

	
	 @Test(dataProvider = "data") 
	 public void fetchDataUsingDataProvider(String
	  name, String gender, String mobile_no, String email_id, String landline,
	  String date_of_birth,String pan_number, String citizevshipnumber,String
	  home_address, String office_address, String state, String city, String
	  pin_code, String area, String nominee_name, String nominee_no, String
	  account_type ) {
	  
	  System.out.println("name--->"+name+"  mobile no--->"+mobile_no+"   gender--->  "+ gender+"  emailis---> "+email_id+" landline--->  "+landline +"  date_of_birth--->"+date_of_birth+"  pan_number---> "+pan_number+"  citizevshipnumber---> "+citizevshipnumber+"home_address--->"+home_address+"       		 "+office_address+"      "+state+"       "+city+"      "+pin_code+"      "+area+"    "+nominee_name+"     "+
			  nominee_no+"     "+account_type);
	  
	  }
	 
	
	
	 @DataProvider
	public Object[][] data() throws EncryptedDocumentException, IOException {
		
		
					
			FileInputStream fis = new FileInputStream(IPathConstants.excelFilePath);
			Workbook wb = WorkbookFactory.create(fis);
			
			Sheet sh = wb.getSheet("user details");
						
			  int countRow = sh.getLastRowNum();
			  short countcel = sh.getRow(0).getLastCellNum();
			
			  System.out.println(countcel);
			
			Object[][] obj = new Object[countRow][countcel];
			for(int i=1; i<countRow+1; i++)
			{
				for(int j=0; j<countcel; j++) {
					
				
					obj[i-1][j] = sh.getRow(i).getCell(j).getStringCellValue();
					
				}
			}
			return obj;
		
	}
}
