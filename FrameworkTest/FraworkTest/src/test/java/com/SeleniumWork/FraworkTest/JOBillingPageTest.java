package com.SeleniumWork.FraworkTest;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import resources.Base;

public class JOBillingPageTest extends Base {
	
	@Test
	public void searchJO()
	{
		JOBillingPage jopage = new JOBillingPage();
		jopage.get_JOSearchBox().sendKeys("36927");
		jopage.get_JOSearchBox().sendKeys(Keys.ENTER);
		
	}

	
}
