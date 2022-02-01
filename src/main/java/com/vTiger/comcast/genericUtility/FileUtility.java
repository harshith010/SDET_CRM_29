package com.vTiger.comcast.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * 
 * @author harshith
 *
 */
public class FileUtility 
{
	/**
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./Data/usedata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}

}
