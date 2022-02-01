package com.vTiger.comcast.genericUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
		/**
		 * this will return the Random Number
		 * @return
		 */
		public int getRandomNumber()
		{
			Random ran =new Random();
			int random = ran.nextInt(1000);
			return random;
		}
		/**
		 * this method will return date in specified format
		 * @return
		 */
		public String getCurrentData()
		{
			Date date = new Date();
			String currentDate = date.toString();
			return currentDate;
		}
		public String getFileDateformate()
		{
			Date date = new Date();
			String d = date.toString();
			String[] dte = d.split(" ");
			String YYYY = dte[5];
			String DD = dte[2];
			String MM=dte[1];
			String today= YYYY+"-"+MM+"-"+DD;
			return today;
			
			
		}
}
