package resources;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public static WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String browserName = prop.getProperty("Browser");
		
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public void getScreenShot(String screenshotName) throws IOException
	{
		File srcImage = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcImage, new File(System.getProperty("user.dir")+"\\Screenshots\\"+screenshotName+".png"));		
	}

}
