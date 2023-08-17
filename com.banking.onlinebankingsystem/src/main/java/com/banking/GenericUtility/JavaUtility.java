package com.banking.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;

public class JavaUtility {
	
	/**
	 * this method is used to get random number
	 * @param range
	 * @return
	 */
	public int getRandomNo(int range) {
		
		Random r = new Random();
		return r.nextInt(range);
	}

	/**
	 * this method is used to get number from popup msg
	 * @param popupmsg
	 * @return
	 */
	public String getDigitNumberFromString(String popupmsg) {
		
		
		 String number ="";	 
		 for(int i= 0; i<popupmsg.length(); i++) {
			 
			 char eachC = popupmsg.charAt(i);
			 if(Character.isDigit(eachC)) {
				 number =number+eachC;
			 } 
		 }
		return number;
	}
	
	public void keyPress(String key) throws Throwable {
		
		Robot r = new Robot();
		int a = KeyEvent.VK_1;
		r.keyPress(a);
		r.keyRelease(0);
	}
	
}
