package com.vTiger.comcast.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vTiger.comcast.pomRepositorylib.HomePage;
import com.vTiger.comcast.pomRepositorylib.LoginPage;

public class BaseClass {
	/* object creation for Library */
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebdriverUtility wLib = new WebdriverUtility();
	public WebDriver driver = null;
	
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBS()
	{
		System.out.println("-------CONNECT TO DB----------");
	}
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBC() throws Throwable
	{
		System.out.println("-------Launch Browser-------------");
		String BROWSER = fLib.getPropertyKeyValue("Browser");
		if (BROWSER.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else {
			driver = new ChromeDriver();
		}
		wLib.waitUntilPageLoad(driver);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configBM() throws Throwable{
		/*common data*/
		System.out.println("--------------LOGIN TO vTiger------------------");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PWD = fLib.getPropertyKeyValue("password");
		
		/*Login*/
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PWD);
	}
	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAM()
	{
		System.out.println("--------------LOGOUT FROM vTiger------------------");
		/*Logout*/
		HomePage hp = new HomePage(driver);
		hp.logout();
	}
	@AfterClass(groups= {"smokeTest","regressionTest"})
	/*close Browser*/
	public void configAC() {
		System.out.println("--------------CLOSE THE BROWSER------------------");
		driver.quit();        
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configAS() {
		System.out.println("-------DISCONNECT FROM DB----------");
	}
	

}
