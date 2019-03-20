package com.SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DropDownAutoAdjustable {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.get("https://www.makemytrip.com/");
		
		WebElement source = driver.findElement(By.id("hp-widget__sfrom"));
		source.clear();
		source.click();
		Thread.sleep(1000L);
		source.sendKeys("Bang");
		Thread.sleep(1000L);
		
		for(int i=0;i<3;i++)
		{
			source.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000L);
		}
		
		source.sendKeys(Keys.ENTER);
		Thread.sleep(1000L);
		System.out.println(source.getText());
		

	}

}
