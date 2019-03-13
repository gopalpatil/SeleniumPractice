package com.SeleniumWork.FraworkTest;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import resources.Base;

public class JOBillingItemsPageTest extends Base {
	
	JOBillingItemsPage obj_JOBillingItemsPage;
	@Test
	public void enterIntacctItemID() throws IOException
	{
		
		initializeDriver();
		driver.get("http://2077-w08-vm6/AuthPortalP3/Billing/JoBilling");
		obj_JOBillingItemsPage = new JOBillingItemsPage(driver);
		obj_JOBillingItemsPage.get_txtbox_IntacctItemID().sendKeys("EDP1080");
		obj_JOBillingItemsPage.get_txtbox_IntacctItemID().sendKeys(Keys.ENTER);
	}

}
