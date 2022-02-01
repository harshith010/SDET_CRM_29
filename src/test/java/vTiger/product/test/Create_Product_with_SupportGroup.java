package vTiger.product.test;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Create_Product_with_SupportGroup {
	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis= new FileInputStream("C:/Users/harshith/Desktop/TestData.properties");
		Properties pobj= new Properties(); 
		pobj.load(fis);
		String url = pobj.getProperty("URL");
		String UN = pobj.getProperty("Username");
		String PWD = pobj.getProperty("Password");
		//excel
		Random ran = new Random();
		int randomNum = ran.nextInt(20000);
		
		
		FileInputStream fis_e = new FileInputStream("./Data/testdata2.xlsx");
		Workbook book = WorkbookFactory.create(fis_e);
		String sh = book.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue()+randomNum;
		
		
		WebDriver driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		WebElement ele = driver.findElement(By.id("qccombo"));
		Select dd = new Select(ele);
		dd.selectByVisibleText("New Product");
		driver.findElement(By.name("productname")).sendKeys(sh);
		driver.findElement(By.xpath("//input[@type='radio' and @value='T']")).click();
		WebElement ele1 = driver.findElement(By.name("assigned_group_id"));
		ele1.click();
		Select dd1 = new Select(ele1);
		dd1.selectByVisibleText("Support Group");
		driver.findElement(By.xpath("//input[@class='crmbutton small save' and @value='  Save']")).click();
		WebElement mm = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act= new Actions(driver);
		
		act.moveToElement(mm).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']"));
		
	}

}
