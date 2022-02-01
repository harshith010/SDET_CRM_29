package vTiger.product.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Create_Product_with_quick_Create 
{
	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis= new FileInputStream("./Data/usedata.properties");
		Properties pobj= new Properties();
		pobj.load(fis);
		String URL = pobj.getProperty("url");
		String USN = pobj.getProperty("username");
		String PWD = pobj.getProperty("password");
		
		/*FileInputStream fis_e= new FileInputStream("./Data/testdata2.xlsx");
		Workbook book = WorkbookFactory.create(fis_e);
		Sheet she = book.createSheet("Sheet1");
		Row row = she.createRow(0);
		Cell cell = row.createCell(0);*/
		
		WebDriver driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USN);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PWD);
		Thread.sleep(10000);
		driver.close();
		
		
		
		
		
	}

}
