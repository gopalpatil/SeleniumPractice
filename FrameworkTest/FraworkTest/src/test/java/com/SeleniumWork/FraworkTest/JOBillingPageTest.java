package com.SeleniumWork.FraworkTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import resources.Base;

public class JOBillingPageTest extends Base {
	
	@Test
	public void searchJO() throws IOException
	{
		driver = initializeDriver();
		driver.get("http://2077-w08-vm6/AuthPortalP3/Billing/JoBilling");
		
		JOBillingPage jopage = new JOBillingPage(driver);

		jopage.get_JOSearchBox().sendKeys("36927");
		jopage.get_JOSearchBox().sendKeys(Keys.ENTER);
		
	}

	
}
