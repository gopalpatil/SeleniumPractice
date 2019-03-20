package com.SeleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigateToJOPage {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C://Gopal P//Selenium Drivers//chromedriver_win32//chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://share.rvminc.com/sites/DevTeam/SitePages/Home.aspx");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[text()='http://2077-w08-vm6/AuthPortalP3/']")).click();
		
		driver.findElement(By.xpath("//span[text()='RVM Billing']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement menu_JobOrderBilling = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Job Order Billing']")));
		menu_JobOrderBilling.click();
		
		driver.findElement(By.xpath("//a[@href='#openJoTab']")).click();
		
		WebElement JOSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FilterO_1")));
				//driver.findElement(By.id("FilterO_1"));
		JOSearch.sendKeys("38822");
		JOSearch.sendKeys(Keys.RETURN);
		
		//WebElement JO = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='odd']//td[text()='38822']")));
		//System.out.println("JO# = "+JO.getText());
				
		
	}

}
