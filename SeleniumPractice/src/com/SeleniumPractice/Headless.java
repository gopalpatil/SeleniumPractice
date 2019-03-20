package com.SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Headless {

	public static void main(String[] args) {
		
		/**** HeadLess HtmlUnitDriver *****/
		
		WebDriver driver = new HtmlUnitDriver();
		driver.get("https://www.google.com/");
		System.out.println("Title : "+driver.getTitle());
		
		
		/*
		// HeadLess ChromeDriver //
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");
		System.out.println("Title : "+driver.getTitle());
*/
	}

}
