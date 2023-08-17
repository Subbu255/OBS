package com.banking.obs.practice;

import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.banking.GenericUtility.ExcelFileUtility;
import com.banking.GenericUtility.IPathConstants;

public class GetDataFromExcelUtility {

	public static void main(String[] args) throws Throwable {
		
		
		FileInputStream fis = new FileInputStream(IPathConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("user details");
		
		HashMap<String, String> hm = new HashMap<String, String>();
		
		for(int i=0; i<sh.getRow(0).getLastCellNum(); i++)
		{
			String key = sh.getRow(0).getCell(i).getStringCellValue();
			String value = sh.getRow(1).getCell(i).getStringCellValue();
			hm.put(key, value);
			
		}
		

		System.out.println(hm.get("name"));
	}

}
