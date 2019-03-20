package com.SeleniumPractice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QAClickAcademy {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://qaclickacademy.com/practice.php");
		WebElement chkOption1 = driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
		chkOption1.click();
		boolean selectionValue = chkOption1.isSelected();
		if(selectionValue)
		{
			System.out.println("Check box Option is Selected");
		}
		else
		{
			System.out.println("Check box Option is NOT Selected");
		}
		
		chkOption1.click();
		boolean selectionValue1 = chkOption1.isSelected();
		if(selectionValue1)
		{
			System.out.println("Check box Option is Selected");
		}
		else
		{
			System.out.println("Check box Option is NOT Selected");
		}
		
		//driver.findElements(By.xpath("//*[@type='checkbox']")).size();
		//int countCheckBoxes = listCheckBox.size();
		System.out.println("#of CheckBoxes = "+driver.findElements(By.xpath("//*[@type='checkbox']")).size());
		
		

	}

}
