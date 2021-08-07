package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.Select;
import Base.Base;

public class RoyalCaribbeanAlaska_cruises extends Base 
{
	//Launch the Website
	public void openUrl()
	{
		driver.get("https://www.royalcaribbean.com/alaska-cruises");
	}
	
	//Closing SignUp Alert
	public void alertHandle()
	{
			try 
			{
				driver.findElement(By.xpath("//*[@class='email-capture__close']")).click();
			} catch(Exception e) {}
	}
	
	//Scroll down the page
	public void scrollDown()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	//Click on Holiday Cruises
	public  void searchHolidayCruises()
	{
		try 
		{
			if(driver.findElement(By.linkText("Holiday Cruises")).isDisplayed())
			{
				System.out.println("Holiday Cruises displays: Pass");
				driver.findElement(By.linkText("Holiday Cruises")).click();
				
			}
		}
		catch(Exception e)
		{
			System.out.println("Holiday Cruises displays: Fail");
		}
	}
	
	//Check the presence of search option
	public void validateSearchOption()
	{	
		try 
		{
			if(driver.findElement(By.id("rciSearchHeaderIcon")).isDisplayed())
			{
				driver.findElement(By.id("rciSearchHeaderIcon")).click();
			}
		}
		catch(Exception e) {}	
	}
	
	//Search for "Rhapsody of the Seas"
	public void searchRhapsodyOfTheSeas()
	{
		driver.findElement(By.id("rciSearchInput")).sendKeys("Rhapsody of the Seas");
		driver.findElement(By.id("rciSearchInputIcon")).click();
	}
	
	//Display the Total number of Search Results and Compare it with 300000
	public void compareSearchResults()
	{
		try 
		{
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@class=\"searchResultsNumber__total\"]"));
			String[] searchResults = driver.findElement(By.xpath("//div[@class='searchResultsNumber__total']")).getText().split(" ");
			String r = searchResults[1];
			String s= "";
			for (int i=0 ;i<r.length() ; i++)
			{
				if(r.charAt(i)==',')
				{
					continue;
				}
				else
				{
					s+=r.charAt(i);
				}	
			}
			System.out.println("Number of Search results: "+ r);
			if(Integer.parseInt(s)>300000)
			{
				System.out.println("Search Results is greater than 300000");
			}
			else
			{
				System.out.println("Search Results is less than 300000");
			}
		}	
		catch(StaleElementReferenceException e)
		{
			System.out.println(e.toString());
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	//Find and click on "Deck Plans | Rhapsody of the Seas | Royal Caribbean Cruises"
	public void findAndClick()
	{
		driver.findElement(By.linkText("Deck Plans | Rhapsody of the Seas | Royal Caribbean Cruises")).click();
	}
	
	//Check for the Deck plan image
    public void checkImageDisplay()
    {
    	try 
    	{
    		Thread.sleep(3000);
    		if(driver.findElement(By.xpath("//img[@class='deck-image']")).isDisplayed())
        	{
        		System.out.println("Deck plan image displays: Pass");
        	}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Deck plan image displays: Fail");
    	}
    }
    
    //Select View as Deck Eight
    public void setImageView()
    {
    	new Select(driver.findElement(By.id("deckDropdown"))).selectByVisibleText("Deck Eight"); 	
    }
    
    //Check the presence of Royal Suite
    public void findRoyalSuite()
    {
    	try 
    	{
    		Thread.sleep(3000);
    		if(driver.findElement(By.xpath("//h4[contains(text(),'Royal Suite - 1 Bedroom')]")).isDisplayed())
        	{
            		System.out.println("Royal Suite displays: Pass");
        	}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Royal Suite displays: Fail");
    	}	
    }
}
