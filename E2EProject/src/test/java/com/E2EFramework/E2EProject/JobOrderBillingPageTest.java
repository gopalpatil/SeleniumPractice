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

public class JobOrderBillingPageTest extends Base {
	
	HomePage homepage;
	JobOrderBillingPage joborderbillingpage;
	JobOrderBillingItemsPage joborderbillingitemspage;
	public JobOrderBillingPageTest() throws IOException {
		super();
		
	}

	@BeforeMethod
	public void initiate() throws IOException, InterruptedException
	{
		initateDriver();
		homepage = new HomePage();	
		joborderbillingpage = homepage.click_menuJobOrderBilling();
	}
	
	@Test(priority=1)
	public void verify_lbl_SelectJobOrder()
	{
		Assert.assertTrue(joborderbillingpage.get_lbl_JobOrderBilling());
	}
	
	@Test(priority=2)
	public void verify_tab_InvoiceNotInitiated()
	{
		Assert.assertTrue(joborderbillingpage.get_tab_InvoiceNotInitiated());
	}
	@Test(priority=3)
	public void verify_tab_InvoiceInProgress()
	{
		Assert.assertTrue(joborderbillingpage.get_tab_InvoiceInProgress());
	}
	@Test(priority=4)
	public void verify_tab_InvoiceComplete()
	{
		Assert.assertTrue(joborderbillingpage.get_tab_InvoiceComplete());
	}
	@Test(priority=5)
	public void verify_totalOpenJOsInTabLabel()
	{
		
		boolean flag = joborderbillingpage.get_TotalRecordsOpenJOs();
		Assert.assertTrue(flag);
	}
	@Test(priority=6)
	public void verify_totalCompleteJOsInTabLabel()
	{
		
		boolean flag = joborderbillingpage.get_TotalRecordsCompleteJOs();
		Assert.assertTrue(flag);
	}
	@Test(priority=7)
	public void verify_JOPresent_NotInitiateTab()
	{
		String JoNumber = joborderbillingpage.getJO_IfPresnent_NotInitiateTab();
		Assert.assertTrue(JoNumber.equals(properties.getProperty("JONumber")));		
	}
	
	@Test(priority=8)
	public void click_InitiateButton() throws IOException
	{
		@SuppressWarnings("unused")
		String JoNumber = joborderbillingpage.getJO_IfPresnent_NotInitiateTab();
		joborderbillingitemspage = joborderbillingpage.click_InitiateBillingButton();		
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	

}
