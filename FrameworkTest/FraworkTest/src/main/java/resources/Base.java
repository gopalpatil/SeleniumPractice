package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\gpatil\\git\\SeleniumPractice\\FrameworkTest\\FraworkTest\\src\\main\\java\\resources\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String browserName = prop.getProperty("Browser");
		
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		return driver;
	}

}
