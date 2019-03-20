package com.SeleniumPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BootstrapDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C://Gopal P//Selenium Drivers//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://share.rvminc.com/sites/DevTeam/SitePages/Home.aspx");
		
		
	//	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"layoutsTable\"]/tbody/tr/td/div/div/blockquote/table/tbody/tr[2]/td[3]/p[5]/a")).click();
		
		WebElement menu_RVMDashboard = driver.findElement(By.xpath("//span[contains(text(),'RVM Dashboard')]"));
		Actions action = new Actions(driver);
		action.moveToElement(menu_RVMDashboard).build().perform();
		
		Thread.sleep(2000L);
		
		List<WebElement> subMenu = driver.findElements(By.xpath("//span[contains(text(),'RVM Dashboard')]/following-sibling::div/ul/li/span"));
		
		a:
		for(WebElement subMenue:subMenu)
		{
			action.moveToElement(subMenue).build().perform();
			Thread.sleep(2000L);
			if(subMenue.getText().equals("DocReview Dashboard Configuration"))
			{
				List<WebElement> dr_Menu = driver.findElements(By.xpath("//span[contains(text(),'DocReview Dashboard Configuration')]/following-sibling::div/ul/li"));
				
				for(WebElement dr_menue: dr_Menu)
				{
					if(dr_menue.getText().equals("Phases"))
					{
						dr_menue.click();
						break a;
					}
					
				}
				break a;
			}
			
			
		}
		
		
		
		
					
	}
}
