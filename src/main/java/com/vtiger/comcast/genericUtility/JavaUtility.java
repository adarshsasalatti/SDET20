package com.vtiger.comcast.genericUtility;

import java.util.Date;
import java.util.Random;

/**
 *  this class contains java specific generic libraries
 * @author LENOVO
 *
 */

public class JavaUtility {
	
	/**
	 * it is used to generate the integer random within the boundary of 0 to 1000
	 * 
	 * @return intData
	 */
	
	public int getRandomNumber() {
		Random random = new Random();
		int randomNum = random.nextInt(1000);
		return randomNum;
	}
	
	/**
	 * it is used to get the current system date and time
	 * @return
	 */

	public String getSystemDate()
	{
		Date date = new Date();
		String systemDateAndTime = date.toString();
	    return systemDateAndTime;
	}
}
