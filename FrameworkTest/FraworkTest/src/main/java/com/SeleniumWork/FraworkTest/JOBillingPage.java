package com.SeleniumWork.FraworkTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JOBillingPage {
	
	public WebDriver driver;
	
	@FindBy(xpath ="//input[@id='FilterO_1']")
	WebElement JOSearchBox;
	
	@FindBy(xpath = "//button[contains(text(),'Initiate Billing')]")
	WebElement btn_InitiateBilling;
	
	public JOBillingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement get_JOSearchBox()
	{
		return JOSearchBox;
	}
	public WebElement get_btn_InitiateBilling()
	{
		return btn_InitiateBilling;
	}

}
