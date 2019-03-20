package com.E2EFramework.E2EProject.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.E2EFramework.E2EProject.BaseClass.Base;

public class JobOrderBillingItemsPage extends Base{
	
	@FindBy(xpath="//label[contains(text(),'Billing Status:')]/following-sibling::span")
	WebElement JoBillingStatus;
	
	@FindBy(xpath="//span[text()='Billing Closing Notes']")
	WebElement btn_BillingClosingNote;
	
	@FindBy(xpath="//input[@id='txtFnl']")
	WebElement ifrm_txt_BillingClosing_ShortDesc;
	
	@FindBy(xpath="//html/descendant::br//parent::body[@contenteditable='true']")
	WebElement ifrm_BodyField;
	
	@FindBy(xpath="//button[text()='Save (As Draft)']//following-sibling::button[text()='Close']")
	WebElement ifrm_btn_Close;
	
	public JobOrderBillingItemsPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean get_JobNumberTitle()
	{
		WebElement JoNumberTitle;
		JoNumberTitle = driver.findElement(By.xpath("//a[text()='Job Orders' and @href='/AuthPortalP3/Billing/JoBilling']/following-sibling::span[text()='JO# "+properties.getProperty("JONumber")+" Billing Items']"));
		boolean flag = JoNumberTitle.isDisplayed();
		return flag;
	}
	public String get_JoBillingStatus()
	{
		return (JoBillingStatus.getText());
	}
	public void enter_BillingClosingNotes() throws InterruptedException
	{
		btn_BillingClosingNote.click();
		ifrm_txt_BillingClosing_ShortDesc.sendKeys("Test Billing Note Short Description ...");
		
		//WebElement frame1 = driver.findElement(By.xpath("//div[@id='AttachFNLPopUp']/descendant::iframe"));
		//driver.switchTo().frame(frame1);
		
		driver.switchTo().frame(0);
		
		ifrm_BodyField.sendKeys("This is Test Body");
		driver.switchTo().parentFrame();
		ifrm_btn_Close.click();
		
	}

}
