package com.SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarControl {
	public static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		/*
		 * driver.get("https://www.makemytrip.com/");
		 * driver.findElement(By.xpath("//input[@id='hp-widget__depart']")).
		 * click();
		 * 
		 * int monthCount =
		 * driver.findElements(By.xpath("//*[@class='ui-datepicker-month']")).
		 * size(); for(int i = 0; i<monthCount; i++) { WebElement we_count =
		 * driver.findElements(By.xpath("//*[@class='ui-datepicker-month']")).
		 * get(i); System.out.println("#### "+we_count.getText()); if
		 * (we_count.getText().contains("April")) { break; } else { String attr
		 * = we_count.findElement(By.xpath(
		 * "//parent::div[@class='ui-datepicker-title']/preceding-sibling::a/span"
		 * )).getText(); System.out.println("Attribute = "+attr);
		 * we_count.findElement(By.xpath(
		 * "//parent::div[@class='ui-datepicker-title']/preceding-sibling::a/span"
		 * )).click(); } }
		 */
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// System.setProperty("webdriver.chrome.driver","C:\\Program
		// Files\\chromedriver.exe");

		// driver = new ChromeDriver();

		driver.get("https://www.etihad.com/en-us");
		//driver.findElement(By.xpath("//*[@id=\"t1-p1\"]/fieldset/div[4]/div[1]/div/span")).click();
		driver.findElement(By.xpath("//input[@id='frm_2012158061206151238']")).click();
		WebDriverWait w = new WebDriverWait(driver, 20);
		DateSelect("March", "2019", "12");

		// System.out.println(s);
		// String s1=
		// driver.findElement(By.xpath("(.//*[@class=\"ui-datepicker-month\"])[1]")).getText();
		// System.out.println(s1);
		
					
	}

	public static void DateSelect(String Month, String Year, String Day)

	{
		// String s=
		// driver.findElement(By.xpath("(.//*[@class=\"ui-datepicker-year\"])[1]")).getText();
		// System.out.println(s);

		String s = driver.findElement(By.xpath("(.//*[@class=\"ui-datepicker-year\"])[1]")).getText();
		int y = Integer.parseInt(Year) - Integer.parseInt(s);
		System.out.println(y);
		if (y >= 1)
		{
			while (!driver.findElement(By.xpath("(.//*[@class=\"ui-datepicker-year\"])[1]")).getText().equals(Year))
			{
				driver.findElement(By.xpath("//span[contains(@class,'ui-icon ui-icon-circle-triangle-e')]")).click();
			}
			while (!driver.findElement(By.xpath("(.//*[@class=\"ui-datepicker-month\"])[1]")).getText().equals(Month))
			{
				driver.findElement(By.xpath("//span[contains(@class,'ui-icon ui-icon-circle-triangle-e')]")).click();
			}
			List<WebElement> dates = driver.findElements(By.className("ui-state-default"));
			// grab the attribute //put into list & iterate
			int count = driver.findElements(By.className("ui-state-default")).size();
			for (int i = 0; i < count; i++)
			{
				String text = driver.findElements(By.className("ui-state-default")).get(i).getText();
				if (text.equalsIgnoreCase(Day))
				{
					driver.findElements(By.className("ui-state-default")).get(i).click();
					break;
				}
			}
		}
	}
}
