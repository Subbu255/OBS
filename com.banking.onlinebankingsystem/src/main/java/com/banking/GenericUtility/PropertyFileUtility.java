package com.banking.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertyFileUtility implements IPathConstants {
	
	/**
	 * this method is used to get the data from property file
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyData(String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream(propertyFilePath);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}

	
	/**
	 * this method is used to write the data back to property file
	 * @param key
	 * @param value
	 * @throws Throwable
	 */
	public void setPropertyData(String key, String value) throws Throwable {
		
		FileInputStream fis = new FileInputStream(propertyFilePath);
		Properties p = new Properties();
		p.load(fis);
		p.setProperty(key, value);
		FileOutputStream fos = new FileOutputStream(propertyFilePath);
		p.store(fos, "successfully updated");
	}
	
}
