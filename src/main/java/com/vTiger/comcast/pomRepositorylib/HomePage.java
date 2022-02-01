package com.vTiger.comcast.pomRepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTiger.comcast.genericUtility.WebdriverUtility;

public class HomePage extends WebdriverUtility {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[.='Contacts']")
	private WebElement contactLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;

	public void logout() {
		mouseMoveOver(driver, adminImg);
		signOutLnk.click();
	}

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	


}
