package demo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTest_dataProvider 
{
	@Test(dataProvider="bookTicketDataProvider")
	public void bookTicket(String dest, int tickets) {
		System.out.println("Destination:::::"+dest+"         "+"Tickets::::: "+tickets);
		
	}
	
	@DataProvider
	public Object[][] bookTicketDataProvider(){
		Object[][] objArr= new Object[5][2];
		objArr[0][0] = "Udupi";
		objArr[0][1] = 10;
		
		objArr[1][0] = "Banglore";
		objArr[1][1] = 10;
		
		objArr[2][0] = "Mysore";
		objArr[2][1] = 15;
		
		objArr[3][0] = "Raichur";
		objArr[3][1] = 12;
		
		objArr[4][0] = "Manglore";
		objArr[4][1] = 30;
		return objArr;
	}

}
