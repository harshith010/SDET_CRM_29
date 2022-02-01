package com.vTiger.comcast.pomRepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTiger.comcast.genericUtility.WebdriverUtility;

public class CreateNewContactPage extends WebdriverUtility {
		WebDriver driver;
		public CreateNewContactPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(name="lastname")
		private WebElement lastNameEdt; 
		

	    @FindBy(xpath="//input[@title='Save [Alt+S]']")
	    private WebElement saveBtn;
	    
	   
	    @FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	    private WebElement orgLookUpImg;
	    

	    /**
	     *used to create new contacts with mandate information 
	     * @param contactLastName
	     */
	    public void createContact(String contactLastName){
	    lastNameEdt.sendKeys(contactLastName);
	    saveBtn.click();
	    }
	    
	    /**
	     *used to create new contacts with mandate information 
	     * @param contactLastName
	     */
	    public void createContact(String contactLastName, String orgName){
	    	lastNameEdt.sendKeys(contactLastName);
	    	orgLookUpImg.click(); 
	    	switchToWindow(driver, "Accounts&action");
	    	
	    	OrganizationsPage op = new OrganizationsPage(driver);
	    	op.getSearchEdt().sendKeys(orgName);
	    	op.getSearchBtn().click();
	    	driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	    	
	    	switchToWindow(driver, "Contacts&action");
	    	saveBtn.click();
	    	}
	    
			/**
			 * @return the lastNameEdt
			 */
		public WebElement getLastNameEdt() {
			return lastNameEdt;
			}
			/**
			 * @return the saveBtn
			 */
		public WebElement getSaveBtn() {
			return saveBtn;
		}


}
