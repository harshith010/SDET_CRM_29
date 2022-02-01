package com.vTiger.comcast.pomRepositorylib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindAll;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getUserPwdEdt() {
		return userPwdEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	@FindBy(name="user_password")
	private WebElement userPwdEdt;
	
	@FindAll ({@FindBy(id="submitButton"), @FindBy(xpath="//input[@type='submit']")})
	private WebElement loginBtn;
	
	public void loginToApp(String username,String password)
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		usernameEdt.sendKeys(username);
		userPwdEdt.sendKeys(password);
		loginBtn.click();
	}
}



