package Base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base 
{
	public static WebDriver driver;
	public static Properties prop;
	
	//Driver Setup
	public void setUpDriver()
	{
		prop = new Properties();
		try {
			prop.load(new FileInputStream("src/main/java/Configure/Configure.Properties"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}if(prop.getProperty("browserName").matches("chrome"))
		{
			driver=new ChromeDriver();
		}
		if(prop.getProperty("browserName").matches("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
	}
	
	//Closing the Browser
	public void closeBrowser()
	{
		driver.quit();
	}
}
