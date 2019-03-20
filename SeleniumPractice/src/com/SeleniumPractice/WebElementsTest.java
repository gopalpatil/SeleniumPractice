package com.SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementsTest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		/*
		 * //******** Drop down Selections **********************
		 * driver.get("http://priny-qastars/STARS/MediaLogging.aspx"); int
		 * ddClientSize = driver.findElements(By.xpath(
		 * "//select[@id='MediaLogging1_ddlClient']/option")).size();
		 * System.out.println("DropDownSize = "+ddClientSize); List<WebElement>
		 * elementClientDD = driver.findElements(By.xpath(
		 * "//select[@id='MediaLogging1_ddlClient']/option"));
		 * 
		 * for(int i = 0; i<ddClientSize; i++) { String ddValue =
		 * elementClientDD.get(i).getText(); //System.out.println(ddValue);
		 * if(ddValue.equals("eCap_Feb16Release")) {
		 * elementClientDD.get(i).click(); break; } }
		 * 
		 * Thread.sleep(2000); List<WebElement> elementProjectDD =
		 * driver.findElements(By.xpath(
		 * "//select[@id='MediaLogging1_ddlProject']/option")); int
		 * ddProjectSize = elementProjectDD.size();
		 * System.out.println("Project DropDown Size = "+ddProjectSize); for(int
		 * i = 0; i<ddProjectSize; i++) { String ddProjectValue =
		 * elementProjectDD.get(i).getText();
		 * //System.out.println(ddProjectValue);
		 * if(ddProjectValue.equals("Revelation_Test")) {
		 * elementProjectDD.get(i).click(); break; } }
		 * 
		 * WebElement selectedClientValue = driver.findElement(By.xpath(
		 * "//select[@id='MediaLogging1_ddlClient']/option[@selected='selected']"
		 * ));
		 * System.out.println("Selected Client = "+selectedClientValue.getText()
		 * );
		 * 
		 * //*******************************************************
		 * 
		 * //******** Check Box Selections **********************
		 * Thread.sleep(4000); driver.findElement(By.xpath(
		 * "//*[@id='MediaLogging1_tvFoldersn8CheckBox']")).click();
		 * driver.findElement(By.xpath(
		 * "//*[@id='MediaLogging1_tvFoldersn7CheckBox']")).click();
		 * driver.findElement(By.xpath(
		 * "//*[@id='MediaLogging1_tvFoldersn8CheckBox']")).click(); boolean
		 * chkSelection = driver.findElement(By.xpath(
		 * "//*[@id='MediaLogging1_tvFoldersn7CheckBox']")).isSelected();
		 * System.out.println("CheckBox N: "+chkSelection);
		 * 
		 * boolean chkSelection1 = driver.findElement(By.xpath(
		 * "//*[@id='MediaLogging1_tvFoldersn8CheckBox']")).isSelected();
		 * System.out.println("CheckBox O: "+chkSelection1);
		 * 
		 * //*******************************************************
		 */

		// ************** Alert Popup *********************************
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='submit']")).click();

		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println("Alert 1 Text = " + alertText);
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		/*
		 * String alertText1 = driver.switchTo().alert().getText();
		 * System.out.println("Alert 2 Text = "+alertText1); Thread.sleep(3000);
		 * driver.switchTo().alert().accept();
		 */

		// ************************************************************

	}

}
