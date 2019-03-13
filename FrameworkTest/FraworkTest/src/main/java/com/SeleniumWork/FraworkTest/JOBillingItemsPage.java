package com.SeleniumWork.FraworkTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JOBillingItemsPage {
	
	@FindBy(xpath = "//table[@id='billingItemTable']/tfoot/tr[1]/th[8]")
	WebElement txtbox_IntacctItemID;
	
	WebDriver driver;
	public JOBillingItemsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement get_txtbox_IntacctItemID()
	{
		return txtbox_IntacctItemID;
	}

}
