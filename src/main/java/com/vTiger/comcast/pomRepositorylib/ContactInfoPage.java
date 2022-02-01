package com.vTiger.comcast.pomRepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement orgHeaderSucMsg;

	@FindBy(id = "mouseArea_Organization Name")
	private WebElement orgNAmeInfo;

	/**
	 * @return the orgNAmeInfo
	 */
	public WebElement getOrgNAmeInfo() {
		return orgNAmeInfo;
	}

	/**
	 * @return the orgHeaderSucMsg
	 */
	public WebElement getOrgHeaderSucMsg() {
		return orgHeaderSucMsg;
	}

	@FindBy(xpath = "//span[@class='dvHeaderTex']")
	private WebElement succesfullMsg;

	/**
	 * @return the succesfullMsg
	 */
	public WebElement getSuccesfullMsg() {
		return succesfullMsg;

	}

}
