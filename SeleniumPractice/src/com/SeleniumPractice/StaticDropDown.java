package com.SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://priny-qastars/STARS/Overview.aspx");
		
		WebElement dd_View = driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder1_Overview1_ddlItemsPerPage"));
		
		Select s = new Select(dd_View);
		/*To Select dropdown value */
		s.selectByIndex(1); //If Index has been given in HTML code
		s.selectByValue("9999"); //if 'Value' attribute is given with some values in the code
		s.selectByVisibleText("100"); //if text is given with some values in the code
		
		/*To get first selected value */
		System.out.println(s.getFirstSelectedOption().getText()); //to get selected text
		
		/*To display all dropdown values */
		List<WebElement> list = s.getOptions();
		System.out.println("List Size = "+list.size());
		for(int i =0; i<list.size(); i++)
		{
			System.out.println(i+" "+list.get(i).getText());
		}
		
		/* Other useful methods in Select Class
		s.deselectAll();
		s.deselectByIndex(arg0);
		s.deselectByValue(arg0);
		*/

	}

}
