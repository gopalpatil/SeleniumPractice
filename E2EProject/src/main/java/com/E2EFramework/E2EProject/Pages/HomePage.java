package com.E2EFramework.E2EProject.Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.E2EFramework.E2EProject.BaseClass.Base;

public class HomePage extends Base{
	
	@FindBy(xpath="//span[contains(text(),'RVM Dashboard')]")
	WebElement menuRVMDashboard;
	
	@FindBy(xpath="//ul[@id='Menu']/li/span")
	List<WebElement> menuItems;
	
	@FindBy(xpath="//ul[@id='Menu']/li[1]/div/ul/li/span")
	List<WebElement> sublist1_menuRVMDashboard;
	
	@FindBy(xpath="//ul[@id='Menu']/li[1]/div/ul/li/span[text()='General Configuration']")
	WebElement subMenu_GeneralConfiguration;
	
	@FindBy(xpath="//span[text()='General Configuration']/following::div[1]/ul/li/a")
	List<WebElement> sublist2_MenuGeneralConfiguration;
	
	@FindBy(xpath="//ul[@id='Menu']/li/span[text()='RVM Billing']")
	WebElement menu_RVMBilling;
	
	@FindBy(xpath="//ul[@id='Menu']/li/span[text()='RVM Billing']/following::div[1]/ul/li/a[text()='Job Order Billing']")
	WebElement menu_JOBilling;
	
	public HomePage() throws IOException
	{
		PageFactory.initElements(driver, this); 
	}	
	
	public String getWebPageTitle()
	{
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public String[] getMenuItems() throws InterruptedException
	{
		int count_MenuItems = menuItems.size();
		String[] MenuItemList = new String[count_MenuItems];
		for(int i=0;i<count_MenuItems;i++)
		{
			MenuItemList[i] = menuItems.get(i).getText();			
		}
		
		return MenuItemList;		
	}

	
	public String[] getSubMenu1_menuRVMDashboard() throws InterruptedException
	{
		Actions builder = new Actions(driver);
		Action moveMouse = builder.moveToElement(menuRVMDashboard).build();
		moveMouse.perform();
		Thread.sleep(1000);
		int count_SubMenuItems = sublist1_menuRVMDashboard.size();
		String[] subMenuItem_menuRVMDashboard = new String[count_SubMenuItems];
		for(int i=0;i<count_SubMenuItems;i++)
		{
			subMenuItem_menuRVMDashboard[i] = sublist1_menuRVMDashboard.get(i).getText();			
		}
		
		return subMenuItem_menuRVMDashboard;		
	}

	public String[] getSubMenu2_SubMenuGeneralConfiguration() throws InterruptedException
	{
		Actions builder = new Actions(driver);
		Action moveMouse = builder.moveToElement(menuRVMDashboard).build();
		moveMouse.perform();
		Thread.sleep(1000);
		moveMouse = builder.moveToElement(subMenu_GeneralConfiguration).build();
		moveMouse.perform();
		Thread.sleep(1000);
		int count_SubMenuItems = sublist2_MenuGeneralConfiguration.size();
		String[] subMenuItem_MenuGeneralConfiguration = new String[count_SubMenuItems];
		for(int i=0;i<count_SubMenuItems;i++)
		{
			subMenuItem_MenuGeneralConfiguration[i] = sublist2_MenuGeneralConfiguration.get(i).getText();			
		}
		
		return subMenuItem_MenuGeneralConfiguration;	
	}
	
	
	public JobOrderBillingPage click_menuJobOrderBilling() throws InterruptedException, IOException {
		Actions builder = new Actions(driver);
		Action moveMouse = builder.moveToElement(menu_RVMBilling).build();
		moveMouse.perform();
		Thread.sleep(1000);
		moveMouse = builder.moveToElement(menu_JOBilling).build();
		moveMouse.perform();
		menu_JOBilling.click();
		return new JobOrderBillingPage();
	}

}
