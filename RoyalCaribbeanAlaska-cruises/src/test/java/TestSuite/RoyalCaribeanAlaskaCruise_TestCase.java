package TestSuite;

import org.testng.annotations.Test;

import Pages.RoyalCaribbeanAlaska_cruises;

public class RoyalCaribeanAlaskaCruise_TestCase 
{
	@Test
	public void testing()
	{
		RoyalCaribbeanAlaska_cruises obj=new RoyalCaribbeanAlaska_cruises();
		obj.setUpDriver();
		obj.openUrl();
		obj.alertHandle();
		obj.scrollDown();
		obj.searchHolidayCruises();
		obj.validateSearchOption();
		obj.searchRhapsodyOfTheSeas();
		obj.compareSearchResults();
		obj.findAndClick();
		obj.checkImageDisplay();
		obj.setImageView();
		obj.findRoyalSuite();
		obj.closeBrowser();
	
	}
}