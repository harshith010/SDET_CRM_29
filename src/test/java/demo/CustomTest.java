package demo;

import org.testng.annotations.Test;

public class CustomTest {
	@Test(priority=1)
	public void createCustomerTest()
	{
		System.out.println("Execute HDFC createCustomerTest ");
	}
	@Test(priority=2)
	public void modifyCustomerTest()
	{
		System.out.println("execute HDFC modifyCustomerTest");
	}

	@Test(priority=3)
	public void deleteCustomerTest()
	{
		System.out.println("execute HDFC deleteCustomeTest");
	}

}
