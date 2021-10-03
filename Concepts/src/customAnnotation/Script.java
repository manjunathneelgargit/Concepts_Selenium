package customAnnotation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Script extends Base
{
	@Authors(authors = { "Manjunath" }, category = {CategoryType.REGRESSION})
	@Test
	public void createContact()
	{
		System.out.println("This is Create Contact Script");
		ExtentLogger.pass("This is Create Contact Script"); //This is extent log
	}
	
	@Authors(authors = { "Akash" }, category = {CategoryType.SMOKE})
	@Test
	public void updateContact()
	{
		System.out.println("This is Update Contact Script");
		Assert.assertTrue(false);
		ExtentLogger.pass("This is Update Contact Script"); //This is extent log
	}
	
	@Authors(authors = { "Abhi" }, category = {CategoryType.UAT})
	@Test
	public void deleteContact()
	{
		System.out.println("This is Delete Contact Script");
		ExtentLogger.pass("This is Delete Contact Script"); //This is extent log
	}
}
