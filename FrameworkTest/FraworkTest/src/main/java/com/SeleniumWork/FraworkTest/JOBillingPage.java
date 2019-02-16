package com.SeleniumWork.FraworkTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JOBillingPage {
	
	WebDriver driver;
	@FindBy(xpath ="//input[@id='FilterO_1']")
	WebElement JOSearchBox;
	
	public JOBillingPage()
	{
		this.driver = driver;
	}
	
	public WebElement get_JOSearchBox()
	{
		return JOSearchBox;
	}

}
