package com.SeleniumWork.FraworkTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import resources.Base;

//@Listeners(MyClassListners.class)

public class JOBillingPageTest extends Base {
	
	JOBillingPage jopage;
	@Test(priority=1)
	public void searchJO() throws IOException, InterruptedException
	{
		initializeDriver();
		Reporter.log("Driver Initialized");
		driver.get("http://2077-w08-vm6/AuthPortalP3/Billing/JoBilling");
		Reporter.log("Website launched");
		jopage = new JOBillingPage(driver);
		jopage.get_JOSearchBox().sendKeys("39513");
		Reporter.log("JO# entered");
		jopage.get_JOSearchBox().sendKeys(Keys.ENTER);		
	}
	
	@Test(priority=2)
	public void clickButton()
	{
		jopage.get_btn_InitiateBilling().click();	
		Reporter.log("Clicked on Initiate Billing");
	}
	
	@Test(priority=3)
	public void verifyPageName()
	{
		Assert.assertTrue(driver.getTitle().equals("RVM Dashboard™ - Admin Portal12"));
		Reporter.log("Web page title fetched");
	}

	
}
