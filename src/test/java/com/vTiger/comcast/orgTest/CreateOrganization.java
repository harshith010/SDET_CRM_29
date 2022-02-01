package com.vTiger.comcast.orgTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vTiger.comcast.genericUtility.BaseClass;
import com.vTiger.comcast.pomRepositorylib.CreatingNewOrgPage;
import com.vTiger.comcast.pomRepositorylib.HomePage;
import com.vTiger.comcast.pomRepositorylib.OrganizationInfoPage;
import com.vTiger.comcast.pomRepositorylib.OrganizationsPage;

public class CreateOrganization extends BaseClass{
	@Test()
	public void createOrgTest() throws Throwable {
		/* read test Data */
		String orgName = eLib.getDatafromExcel("org", 1, 2) + "-" + jLib.getRandomNumber();

		/* Step 1: Navigate to Org */
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		/* Step 2: navigate to create new orgPage */
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreatOrgBtn().click();

		/* Step 3: Create Org */
		CreatingNewOrgPage cnop = new CreatingNewOrgPage(driver);
		cnop.createOrg(orgName);

		/* Step 4: Verify */
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		
		Assert.assertTrue(oip.getSuccesfullMsg().getText().contains(orgName));
		System.out.println("org is created Successfully==> Pass");

	}

	@Test()
	public void CreateOrgWithIndustriesTypeTes() throws Throwable {
		// read test data
		String orgName = eLib.getDatafromExcel("org", 4, 2) + "-" + jLib.getRandomNumber();
		String Industries = eLib.getDatafromExcel("org", 4, 3);

		// step 2:- navigate to Org page
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step 3:- navigate create new org page
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreatOrgBtn().click();

		// step 4 :- create Org
		CreatingNewOrgPage cnop = new CreatingNewOrgPage(driver);
		cnop.createOrg(orgName);

		// step 5:- verify the org details
		OrganizationInfoPage oi = new OrganizationInfoPage(driver);
		wLib.waitForElementVisibility(driver, oi.getSuccesfullMsg());
		Assert.assertTrue(oi.getSuccesfullMsg().getText().contains(orgName));
		System.out.println("org created succesufully-pass");

		// step 6:- verify industries details
		Assert.assertTrue(oi.getIndustriesInfo().getText().contains(Industries));
		System.out.println("org created with industries succesufully-pass");

	}
}
