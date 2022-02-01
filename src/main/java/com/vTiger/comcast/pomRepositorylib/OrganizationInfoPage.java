package com.vTiger.comcast.pomRepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage 
{
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@type='text' and @name='accountname']")
	private WebElement orgName;

	@FindBy(xpath = "//img [@src='themes/softed/images/select.gif']")
	private WebElement memberOf;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@name='assigntype' and @value='T']")
	private WebElement asignToGroup;
	
	@FindBy(xpath="//input[@name='assigntype' and @value='U']")
	private WebElement asignToUser;
	
	@FindBy(className="dvHeaderText")
	private WebElement orgHeaderSucMsg;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getMemberOf() {
		return memberOf;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getAsignToGroup() {
		return asignToGroup;
	}

	public WebElement getAsignToUser() {
		return asignToUser;
	}

	public WebElement getOrgHeaderSucMsg() {
		return orgHeaderSucMsg;
	}

	public WebElement getIndustriesInfo() {
		return industriesInfo;
	}
	@FindBy(id="dtlview_Industry")
    private WebElement industriesInfo;
	
	
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement succesfullMsg;
	
	public WebElement getSuccesfullMsg() {
		return succesfullMsg;
	}
	
}
