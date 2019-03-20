package com.SeleniumPractice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;


public class StarsHomePage {

	WebDriver driver;

  @BeforeTest
  public void beforeTest() {
	  
	  System.out.println("Test Started");
	    System.setProperty("webdriver.chrome.driver", "C:\\Gopal P\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	  
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Test Completed");
  }
  
  @Test(priority=1)
  public void verifyURL() throws InterruptedException 
  {

		driver.get("http://priny-qastars/STARS/Overview.aspx");
		driver.manage().window().maximize();
				
		
		boolean isRVMLogoDisplayed = driver.findElement(By.xpath("//*[@id=\"ctl00_topmenubar\"]/tbody/tr/td[1]/img")).isDisplayed();
		Assert.assertTrue(isRVMLogoDisplayed);
	
		boolean isAboutMenuDisplayed = driver.findElement(By.xpath("//*[@id=\"ctl00_RadMenu\"]/ul/li[5]/a/span")).isDisplayed();
		Assert.assertTrue(isAboutMenuDisplayed);
		
		String isPrintPreviewLinkDisplayed = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_Overview1_lnkPrintPreview\"]")).getText();
		Assert.assertTrue(isPrintPreviewLinkDisplayed.contains("Preview"));
		
		
		String isClientDisplayed = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_Overview1_GridView2_ctl01_lbClient\"]")).getText();
		Assert.assertEquals(isClientDisplayed, "Client");

		String searchPage = driver.getTitle();
		Assert.assertTrue(searchPage.contentEquals("RVM STARS - Dev"));
	  
  }

  @Test(priority=2)
  public void starsSearch() throws InterruptedException
  {
	  driver.findElement(By.xpath("//*[@id=\"ctl00_tbSearch\"]")).sendKeys("Elmer Fudd");
	  driver.findElement(By.xpath("//*[@id=\"ctl00_ibSearch\"]")).click();
	  
	 WebElement table_element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ap2_content_gvProject"));
	 List<WebElement> table_rows = table_element.findElements(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ap2_content_gvProject']/tbody/tr"));
	 List<WebElement> table_row_1 = table_rows.get(0).findElements(By.tagName("th"));
	
	 int i=0;
	 int Projects_ColumnNo=0;
	 int ContactLawyer_ColumnNo=0;
	 int Client_ColumnNo=0;
	 int LawFirm_ColumnNo=0;
	 for(WebElement row_1: table_row_1)
	 {
		
		if(row_1.getText().contentEquals("Contact Lawyer"))
		{
			 ContactLawyer_ColumnNo = i;
		}
		if(row_1.getText().contentEquals("Projects"))
		{
			 Projects_ColumnNo = i;
		}
		if(row_1.getText().contentEquals("Client"))
		{
			 Client_ColumnNo = i;
		}
		if(row_1.getText().contentEquals("Law Firm"))
		{
			LawFirm_ColumnNo = i;
		}
		i++;
	 }
	 int starsSearch=0;
	 for(int table_row=1;table_row< table_rows.size();table_row++)
	 {
		 List<WebElement> table_row_all = table_rows.get(table_row).findElements(By.tagName("td"));
		 WebElement rowcontent_client = table_row_all.get(Client_ColumnNo);
		 WebElement rowcontent_project = table_row_all.get(Projects_ColumnNo);
		 WebElement rowcontent_lawyer = table_row_all.get(ContactLawyer_ColumnNo);
		 WebElement rowcontent_lawfirm = table_row_all.get(LawFirm_ColumnNo);
		 
		 if(rowcontent_lawyer.getText().trim().equals("Elmer Fudd"))
		 { 
			 if(rowcontent_client.getText().trim().equals("Rev_11122014 (Rev_11122014)") && rowcontent_project.getText().trim().equals("Revelation_Testing") 
					 && rowcontent_lawfirm.getText().trim().equals("Rush and Delay"))
			 {
				 starsSearch = 1;
				 
			 }
		 }
		  
	 }
	 Assert.assertEquals(starsSearch, 1);
  }

  @Test(priority=3)
  public void instructionSearch() throws InterruptedException
  {
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  WebElement home_element = driver.findElement(By.xpath("//*[@id=\"ctl00_RadMenu\"]/ul/li[1]/a/span"));
	  Actions action = new Actions(driver);
	  action.moveToElement(home_element).perform();
	  
	  WebDriverWait wait = new WebDriverWait(driver, 20);
	  
	  WebElement search_element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ctl00_RadMenu\"]/ul/li[1]/div/ul/li[1]/a/span")));
	  	  
	  action.moveToElement(search_element).click().perform();
	  
	  driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_ap3_header_Image3\"]")).click();
	  
	  WebElement list_Clients = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_ap3_content_ddlInstructionClient\"]"));
	  Select dropdown_Client = new Select(list_Clients);
	  
	  dropdown_Client.selectByVisibleText("Rev_11122014");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_ap3_content_tbInstructionSearch\"]")).sendKeys("Search");
	  driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_ap3_content_ibInstructionSearch\"]")).click();
	  
	  List<WebElement> total_Rows = driver.findElements(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_ap3_content_gvInstructionSearch\"]/tbody/tr"));
	  List<WebElement> column_Names = total_Rows.get(0).findElements(By.tagName("th"));
	  int column_JO_No = 0;
	  int i=0;
	  boolean TestPassed_JOPresent = false;
	  boolean TestPassed_instructionPresent = false;
	  for(WebElement column_Name: column_Names)
	  {
		  if(column_Name.getText().equals("JO#"))
		  {
			  column_JO_No = i;
			  break;
		  }
		  i++;
				  
	  }
	  
	  for(int j=1;j<total_Rows.size();j++)
	  {
		 List<WebElement> row_details = total_Rows.get(j).findElements(By.tagName("td"));
		 String JO_Number = row_details.get(column_JO_No).getText();
		 if(JO_Number.equals("37545"))
		 {
			 TestPassed_JOPresent = true;
			 driver.findElement(By.linkText("37545")).click();
			 driver.findElement(By.xpath("//*[@id=\"__tab_ctl00_ContentPlaceHolder1_TabContainer1_tpInstructions\"]")).click();
			 
			String label_GeneralInstructions =  driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_TabContainer1_tpInstructions_Instructions1_UpdatePanel1\"]/table/tbody/tr[7]/td/label/div/span")).getText();
			if(label_GeneralInstructions.equals("General Instructions"))
			{
				String txt_instructions = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_TabContainer1_tpInstructions_Instructions1_UpdatePanel1\"]/table/tbody/tr[7]/td/div/span")).getText();
				if(txt_instructions.equals("Searching in Instructions"))
				{
					TestPassed_instructionPresent = true;
				}
					
			}
			 break;
		 }
	  }
	  Assert.assertEquals(TestPassed_JOPresent, true);
	  Assert.assertEquals(TestPassed_instructionPresent, true);
	  
  }

@Test(priority=4)
public void invalidJO() throws InterruptedException
{
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id=\"jonumber\"]")).sendKeys("1234");
	driver.findElement(By.xpath("//*[@id=\"goJO\"]")).click();
	
	
	boolean isRVMLogoDisplayed = driver.findElement(By.xpath("//*[@id=\"ctl00_topmenubar\"]/tbody/tr/td[1]/img")).isDisplayed();
	Assert.assertTrue(isRVMLogoDisplayed);

	boolean isAboutMenuDisplayed = driver.findElement(By.xpath("//*[@id=\"ctl00_RadMenu\"]/ul/li[5]/a/span")).isDisplayed();
	Assert.assertTrue(isAboutMenuDisplayed);
	
	String isPrintPreviewLinkDisplayed = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_Overview1_lnkPrintPreview\"]")).getText();
	Assert.assertTrue(isPrintPreviewLinkDisplayed.contains("Preview"));
	
	
	String isClientDisplayed = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_Overview1_GridView2_ctl01_lbClient\"]")).getText();
	Assert.assertEquals(isClientDisplayed, "Client");

	String searchPage = driver.getTitle();
	Assert.assertTrue(searchPage.contentEquals("RVM STARS - Dev"));
}

@Test(priority=5)
public void checkExistingJO()
{
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id=\"jonumber\"]")).sendKeys("37540");
	driver.findElement(By.xpath("//*[@id=\"goJO\"]")).click();
	
	String JONumber = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_ExplorerNavigation2_lJobOrder\"]")).getText();
	Assert.assertTrue(JONumber.equals("37540"));
	
	String clientName = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_ExplorerNavigation2_lbClient\"]")).getText();
	Assert.assertTrue(clientName.equals("Rev_11122014"));
	
	String matterName = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_ExplorerNavigation2_lbProject\"]")).getText();
	Assert.assertTrue(matterName.equals("Revelation_Testing (-None-)"));
	
}

@Test(priority=6)
public void verifyClientDetailsPage()
{
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id=\"ctl00_tbSearch\"]")).sendKeys("RVM_QA");
	driver.findElement(By.id("ctl00_ibSearch")).click();
	driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_ap2_content_gvClient_ctl02_lbClient\"]/span")).click();
	String tab1Name = driver.findElement(By.xpath("//*[@id=\"__tab_ctl00_ContentPlaceHolder1_tcClients_tpClientDetails\"]")).getText();
	String tab2Name = driver.findElement(By.xpath("//*[@id=\"__tab_ctl00_ContentPlaceHolder1_tcClients_tpClientSource\"]")).getText();
	String tab3Name = driver.findElement(By.xpath("//*[@id=\"__tab_ctl00_ContentPlaceHolder1_tcClients_tpClientFiles\"]")).getText();
	String tab4Name = driver.findElement(By.xpath("//*[@id=\"__tab_ctl00_ContentPlaceHolder1_tcClients_TabPanel1\"]")).getText();
	
	Assert.assertTrue(tab1Name.equals("Client Details"));
	Assert.assertTrue(tab2Name.equals("Client Source"));
	Assert.assertTrue(tab3Name.equals("Client Files"));
	Assert.assertTrue(tab4Name.equals("Client Instruction Templates"));
	
	String clientFullName = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_tcClients_tpClientDetails_DetailsView1\"]/tbody/tr[1]/td[2]")).getText();
	String clientShortName = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_tcClients_tpClientDetails_DetailsView1\"]/tbody/tr[2]/td[2]")).getText();
	String clientFacingName = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_tcClients_tpClientDetails_DetailsView1\"]/tbody/tr[3]/td[2]")).getText();
	
	Assert.assertTrue(clientFullName.equals("RVM_QA"));
	Assert.assertTrue(clientShortName.equals("RVM_QA"));
	Assert.assertTrue(clientFacingName.equals("RVM_QA"));
	
	
}


}
