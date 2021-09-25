package extentReports_In_Framework_Listeners_Scrnsht;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Script extends Base
{
	@Test
	public void createContact()
	{
		System.out.println("This is Create Contact Script");
		ExtentLogger.pass("This is Create Contact Script"); //This is extent log
	}
	
	@Test
	public void updateContact()
	{
		System.out.println("This is Update Contact Script");
		Assert.assertTrue(false);
		ExtentLogger.pass("This is Update Contact Script"); //This is extent log
	}
	
	@Test
	public void deleteContact()
	{
		System.out.println("This is Delete Contact Script");
		ExtentLogger.pass("This is Delete Contact Script"); //This is extent log
	}
}
