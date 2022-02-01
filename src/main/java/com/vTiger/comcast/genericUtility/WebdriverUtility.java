package com.vTiger.comcast.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebdriverUtility 
{
	/**
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementVisibility(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element)throws InterruptedException
	{
		int count=0;
		while (count<20)
		{try {
			element.click();
			break;}
		catch (Throwable e) {
			Thread.sleep(1000);
			count++;
			}
		}
		}
	/**
	 * 
	 * @param element
	 * @param option
	 */
	public void select(WebElement element,String option ) 
	{
		Select select=new Select(element);
		select.selectByVisibleText(option);
	}
	/**
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
		
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseMoveOver(WebDriver driver, WebElement element)
	{
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * 
	 * @param driver
	 * @param partiaLink
	 */
	public void switchToWindow(WebDriver driver,String partiaLink)
	{
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext())
		{
			String winId = it.next();
			String title = driver.switchTo().window(winId).getTitle();
			if(title.contains(partiaLink))
			{
				break;
			}
		}
	}
	/**
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * 
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollToWebElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		int y= element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
		
	}
	/**
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void switchToElement(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
		
	}
	/**
	 * 
	 * @param driver
	 * @param IdorName
	 */
	public void switchFrame(WebDriver driver, String IdorName) 
	{
		driver.switchTo().frame(IdorName);
		
	}
	public void takeScreenShot(WebDriver driver, String ScreenShotName) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File dest= new File("./screenshot/"+ScreenShotName+".PNG");
		Files.copy(src, dest);
		
	}
	/**
	 * 
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver) 
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		
	}

}


