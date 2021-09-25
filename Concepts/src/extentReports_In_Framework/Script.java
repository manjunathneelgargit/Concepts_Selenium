package extentReports_In_Framework;

import org.testng.annotations.Test;

public class Script extends Base
{
	@Test
	public void createContact()
	{
		System.out.println("This is a sample script");
		ExtentLogger.pass("This is a sample script"); //This is extent log
	}
}
