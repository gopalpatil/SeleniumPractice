package com.SeleniumPractice;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


public class CalendarControl2 {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.makemytrip.com/flights/");
		
		driver.findElement(By.xpath(".//*[@id='hp-widget__depart']")).click(); //Depart Field

		 //Selecting ur desierd month
		Thread.sleep(2000L);

		 while(!driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")).getText().contains("MARCH"))  //Check Month Name
		 {
		  driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']/span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		 }
		 
		 int count1=driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).size();
		 System.out.println(count1);
		  
		for (int i=0;i<count1;i++)
		 {
		  String s1=driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).get(i).getText();
		  System.out.println(s1);
		  
		  if (s1.equalsIgnoreCase("11"))
		  {
		  driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).get(i).click();
		  break;
		  }
		  
		 }
		
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//input[@id='hp-widget__return']")).click();
		Thread.sleep(2000L);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		while(!driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")).getText().contains("MAY"))
		{
			System.out.println("##############################");
			driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']/span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
		

	}

}
