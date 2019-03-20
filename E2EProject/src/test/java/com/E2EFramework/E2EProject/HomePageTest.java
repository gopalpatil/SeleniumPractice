package com.E2EFramework.E2EProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.E2EFramework.E2EProject.BaseClass.Base;
import com.E2EFramework.E2EProject.Pages.HomePage;
import com.E2EFramework.E2EProject.Pages.JobOrderBillingPage;

public class HomePageTest extends Base {
	
	HomePage homepage;
	JobOrderBillingPage joborderbillingpage;
	public HomePageTest() throws IOException 
	{
		
		super();	
		
	}
	
	@BeforeMethod
	public void initate() throws IOException
	{
		
		initateDriver();
		homepage = new HomePage();		
	}
		
	@Test(priority=1)
	public void verifyWebPageTitle() throws IOException
	{

		String pageTitle = homepage.getWebPageTitle();
		Assert.assertTrue(pageTitle.equals("RVM Dashboard™ - Admin Portal"));	
	}
	
	@Test(priority=2)
	public void verifyMenuItems() throws IOException, InterruptedException
	{

		String[] MenuItems = homepage.getMenuItems();
		String[] Expected_MenuItems = {"RVM Dashboard","Coding Hub Configuration","RVM Billing"};
		Assert.assertEquals(MenuItems, Expected_MenuItems);
	}
	
	@Test(priority=3)
	public void verifySubMenu_RVMDashboard() throws IOException, InterruptedException
	{

		String[] subMenuItem_menuRVMDashboard = homepage.getSubMenu1_menuRVMDashboard();
		String[] Expected_subMenuItem_menuRVMDashboard = {"General Configuration","DocReview Dashboard Configuration","Dashboard Security"};
		Assert.assertEquals(subMenuItem_menuRVMDashboard, Expected_subMenuItem_menuRVMDashboard);
	}
	
	@Test(priority=4)
	public void verify_SubMenuGeneralConfiguration() throws InterruptedException
	{
		String[] subMenuItem_menuGeneralConfiguration = homepage.getSubMenu2_SubMenuGeneralConfiguration();
		String[] expected_subMenuItem_menuGeneralConfiguration = {"Matters","Relativity Workspaces","Eclipse Cases","Intacct Configuration"};
		Assert.assertEquals(subMenuItem_menuGeneralConfiguration,expected_subMenuItem_menuGeneralConfiguration);
	}
	
	@Test(priority=5)
	public void verify_JobOrderBillingPage() throws InterruptedException, IOException
	{
		joborderbillingpage = homepage.click_menuJobOrderBilling();		
	}
	
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}

}
