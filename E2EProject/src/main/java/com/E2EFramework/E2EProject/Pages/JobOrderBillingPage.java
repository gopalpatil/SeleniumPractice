package com.E2EFramework.E2EProject.Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.E2EFramework.E2EProject.BaseClass.Base;

public class JobOrderBillingPage extends Base {

	@FindBy(xpath = "//b[contains(text(),'Job Order Billing')]")
	WebElement lbl_JobOrderBilling;

	@FindBy(xpath = "//a[contains(@href,'openJoTab')]")
	WebElement tab_InvoiceNotInitiated;

	@FindBy(xpath = "//a[contains(@href,'closedJoTab')]")
	WebElement tab_InvoiceInProgress;

	@FindBy(xpath = "//a[contains(@href,'completeJoTab')]")
	WebElement tab_InvoiceComplete;

	@FindBy(xpath = "//table[@id='openJoTable']/tbody/child::tr")
	List<WebElement> recordsPerPage;
	
	@FindBy(xpath = "//table[@id='completeJoTable']/tbody/child::tr")
	List<WebElement> recordsPerPage_completeJO;

	@FindBy(xpath = "//div[@id='openJoTable_paginate']/ul/li[contains(@class,'next')]")
	WebElement nextPaginationEnabled;

	@FindBy(xpath = "//div[@id='completeJoTable_paginate']/ul/li[contains(@class,'next')]")
	WebElement nextPaginationEnabled_completeJO;
	
	@FindBy(xpath = "//div[@id='openJoTable_paginate']/ul/li/a[contains(text(),'Next')]")
	WebElement nextPagination;
	
	@FindBy(xpath = "//div[@id='completeJoTable_paginate']/ul/li/a[contains(text(),'Next')]")
	WebElement nextPagination_completeJO;

	@FindBy(xpath = "//a[@href='#openJoTab']/label")
	WebElement count_OpenJOs;
	@FindBy(xpath = "//a[@href='#completeJoTab']/label")
	WebElement count_CompleteJOs;
	
	@FindBy(xpath="//input[@id='FromDate']")
	WebElement dateFrom_CompleteJO;
	
	@FindBy(xpath="//input[@value='Filter']")
	WebElement btn_Filter;
	
	@FindBy(xpath="//input[@id='FilterO_1']")
	WebElement txtBox_JOFilter;
	
	@FindBy(xpath="//table[@id='openJoTable']/tbody/tr/td[@data-bind='text: JobOrderNumber']")
	WebElement JobOrderNumber_inSearchResult;
	
	@FindBy(xpath="//table[@id='openJoTable']/tbody/tr/td[@data-bind='text: JobOrderNumber']/following-sibling::td/button[text()='Initiate Billing']")
	WebElement btn_InitiateBilling;

	int totalRecords_JOs;
	
	public JobOrderBillingPage() throws IOException 
	{
		PageFactory.initElements(driver, this);
	}

	public boolean get_lbl_JobOrderBilling() 
	{
		return (lbl_JobOrderBilling.isDisplayed());
	}

	public boolean get_tab_InvoiceNotInitiated() 
	{
		return tab_InvoiceNotInitiated.isDisplayed();
	}

	public boolean get_tab_InvoiceInProgress() 
	{
		return tab_InvoiceInProgress.isDisplayed();
	}

	public boolean get_tab_InvoiceComplete() 
	{
		return tab_InvoiceComplete.isDisplayed();
	}

	public boolean get_TotalRecordsOpenJOs() 
	{
		tab_InvoiceNotInitiated.click();
		int recordsonPage = 0;
		totalRecords_JOs = 0;
		while (nextPaginationEnabled.getAttribute("class").equals("next")) {
			recordsonPage = recordsPerPage.size();

			totalRecords_JOs = totalRecords_JOs + recordsonPage;

			nextPagination.click();

		}
		recordsonPage = recordsPerPage.size();
		totalRecords_JOs = totalRecords_JOs + recordsonPage;

		int countOfOpenJOs = Integer.parseInt(count_OpenJOs.getText());
		if (countOfOpenJOs == totalRecords_JOs) {
			return true;
		} else {
			return false;
		}
	}

	public boolean get_TotalRecordsCompleteJOs() 
	{
		tab_InvoiceComplete.click();
		dateFrom_CompleteJO.clear();
		dateFrom_CompleteJO.sendKeys("4/1/2018");
		btn_Filter.click();
		int recordsonPage = 0;
		totalRecords_JOs = 0;
		while (nextPaginationEnabled_completeJO.getAttribute("class").equals("next")) {
			recordsonPage = recordsPerPage_completeJO.size();

			totalRecords_JOs = totalRecords_JOs + recordsonPage;

			nextPagination_completeJO.click();

		}
		recordsonPage = recordsPerPage_completeJO.size();
		totalRecords_JOs = totalRecords_JOs + recordsonPage;
		
		int countOfOpenJOs = Integer.parseInt(count_CompleteJOs.getText());
		if (countOfOpenJOs == totalRecords_JOs) 
		{
			return true;
		} 
		else 
		{
			return false;
		}

	}
	
	public String getJO_IfPresnent_NotInitiateTab()
	{
		tab_InvoiceNotInitiated.click();
		txtBox_JOFilter.sendKeys(properties.getProperty("JONumber"));
		txtBox_JOFilter.sendKeys(Keys.ENTER);
		String jobOrderNumber = JobOrderNumber_inSearchResult.getText();
		return jobOrderNumber;
	}
	
	public JobOrderBillingItemsPage click_InitiateBillingButton() throws IOException
	{
		btn_InitiateBilling.click();
		return new JobOrderBillingItemsPage();
	}

}
