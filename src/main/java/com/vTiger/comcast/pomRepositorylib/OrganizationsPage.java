package com.vTiger.comcast.pomRepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage
{
	WebDriver driver;
	public OrganizationsPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement creatOrgBtn;
	
	@FindBy(name="search_text")
	private WebElement SearchEdt;
	
	@FindBy(xpath="//input[@type='button' and @name='search']")
	private WebElement SearchBtn;
	
	public WebElement getSearchBtn() {
		return SearchBtn;
	}
	public WebElement getSearchEdt() {
		return SearchEdt;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getCreatOrgBtn() {
		return creatOrgBtn;
	}
	
	

}
