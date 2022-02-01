package com.vTiger.comcast.pomRepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTiger.comcast.genericUtility.WebdriverUtility;

public class CreatingNewOrgPage extends WebdriverUtility
{
	WebDriver driver;
	public CreatingNewOrgPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industriesLst;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public void createOrg(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	public void createOrg(String orgName,String industries){
    	orgNameEdt.sendKeys(orgName);
    	select(industriesLst,industries);
    	saveBtn.click();
    }
}
