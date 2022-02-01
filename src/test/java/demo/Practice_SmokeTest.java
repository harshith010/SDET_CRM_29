package demo;

import org.testng.annotations.Test;

public class Practice_SmokeTest {
	@Test(groups= {"smokeTest"})
	public void createCustomerTest() {
		System.out.println("Execute createcustomerTest");
	}
	@Test(groups= {"RegressionTest"})
	public void modifyCustomerTest()
	{
		System.out.println("Execute modifyCustomerTest");
	}

}
