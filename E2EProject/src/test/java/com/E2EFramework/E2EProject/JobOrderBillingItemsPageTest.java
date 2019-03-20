package com.E2EFramework.E2EProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.E2EFramework.E2EProject.BaseClass.Base;
import com.E2EFramework.E2EProject.Pages.HomePage;
import com.E2EFramework.E2EProject.Pages.JobOrderBillingItemsPage;
import com.E2EFramework.E2EProject.Pages.JobOrderBillingPage;

public class JobOrderBillingItemsPageTest extends Base{

	HomePage homepage;
	JobOrderBillingPage joborderbillingpage;
	JobOrderBillingItemsPage joborderbillingitemspage;
	
	public JobOrderBillingItemsPageTest() throws IOException 
	{
		super();		
	}
	
	@BeforeMethod
	public void initiate() throws IOException, InterruptedException
	{
		initateDriver();
		homepage = new HomePage();	
		joborderbillingpage = homepage.click_menuJobOrderBilling();
		@SuppressWarnings("unused")
		String nouse1 = joborderbillingpage.getJO_IfPresnent_NotInitiateTab();
		joborderbillingitemspage = joborderbillingpage.click_InitiateBillingButton();
	}
	
	@Test(priority=1)
	public void verify_JobNumberTitle()
	{
		boolean flag = joborderbillingitemspage.get_JobNumberTitle();
		Assert.assertTrue(flag);
	}
	@Test(priority=2)
	public void verify_JoBillingStatus()
	{
		String JoStatus = joborderbillingitemspage.get_JoBillingStatus();
		Assert.assertTrue(JoStatus.equals("Invoice – Not Initiated"));
	}
	@Test(priority=3)
	public void verify_BillingClosingNotes() throws InterruptedException
	{
		joborderbillingitemspage.enter_BillingClosingNotes();
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
}
