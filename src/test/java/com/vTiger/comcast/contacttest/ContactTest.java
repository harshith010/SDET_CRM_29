package com.vTiger.comcast.contacttest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vTiger.comcast.genericUtility.BaseClass;
import com.vTiger.comcast.pomRepositorylib.ContactInfoPage;
import com.vTiger.comcast.pomRepositorylib.ContactsPage;
import com.vTiger.comcast.pomRepositorylib.CreateNewContactPage;
import com.vTiger.comcast.pomRepositorylib.CreatingNewOrgPage;
import com.vTiger.comcast.pomRepositorylib.HomePage;
import com.vTiger.comcast.pomRepositorylib.OrganizationInfoPage;
import com.vTiger.comcast.pomRepositorylib.OrganizationsPage;

public class ContactTest extends BaseClass 
{
	@Test(groups="smokeTest")
	public void createContactTest() throws Throwable
	{
				// Step 1: read test data
				String lastName = eLib.getDatafromExcel("contact", 1, 2) + "-" + jLib.getRandomNumber();
				// step 2:- navigate to contact page
				HomePage hp = new HomePage(driver);
				hp.getContactLink().click();
				// step 3:- create new contact
				ContactsPage cp = new ContactsPage(driver);
				cp.getCreateContactImg().click();
				// step 4 :- create contact
				CreateNewContactPage cnp = new CreateNewContactPage(driver);
				cnp.createContact(lastName);
				// step 5:- verify the contact details
				ContactInfoPage ci = new ContactInfoPage(driver);
				String actLstName = ci.getOrgHeaderSucMsg().getText();
				Assert.assertTrue(ci.getOrgHeaderSucMsg().getText().contains(actLstName));
				System.out.println("contact lastName is verified==>> Pass");
				}	
	
	@Test(groups="RegressionTest")
	public void CreateContactWithOrgTest() throws Throwable {
		// read test data
				String contactName = eLib.getDatafromExcel("contact", 4, 2) + "-" + jLib.getRandomNumber();
				String orgName = eLib.getDatafromExcel("contact", 4, 3) + "-" + jLib.getRandomNumber();
				// step 2:- navigate to Org page
				HomePage hp = new HomePage(driver);
				hp.getOrgLink().click();
				// step 3:- navigate create new org page
				OrganizationsPage op = new OrganizationsPage(driver);
				op.getCreatOrgBtn().click();
				// step 4 :- create Org
				CreatingNewOrgPage cnop = new CreatingNewOrgPage(driver);
				cnop.createOrg(orgName);
				//step 5: Verify orgName Create 
				OrganizationInfoPage oi = new OrganizationInfoPage(driver);
				Assert.assertTrue(oi.getOrgHeaderSucMsg().getText().contains(orgName));
				System.out.println("organization created succesfully");
				//ExplicitWait
				wLib.waitForElementVisibility(driver, oi.getSuccesfullMsg());
				hp.getContactLink().click();
				// *step6:-navigate to create new contact page
				ContactsPage cp = new ContactsPage(driver);
				cp.getCreateContactImg().click();
				// *step7:-create a new contact with orgName page
				CreateNewContactPage cnp = new CreateNewContactPage(driver);
				cnp.createContact(contactName, orgName);
				// *step8-verify
				ContactInfoPage ci = new ContactInfoPage(driver);
				Assert.assertTrue(ci.getOrgHeaderSucMsg().getText().contains(contactName));
				System.out.println("contact last name is verified ==pass");
				
				
	}

}
