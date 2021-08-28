package com.vtiger.comcast.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String getPropertyKeyValue(String string) throws IOException 
	{
		 FileInputStream fis = new FileInputStream("./data/commonData.properties");
    	 Properties pobj = new Properties();
    	 pobj.load(fis);
    	 String value = pobj.getProperty(string);
		return value;


	}

}
