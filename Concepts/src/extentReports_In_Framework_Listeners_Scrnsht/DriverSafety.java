package extentReports_In_Framework_Listeners_Scrnsht;

import org.openqa.selenium.WebDriver;

public class DriverSafety 
{
	private static ThreadLocal<WebDriver> tl = new ThreadLocal<>();
	
	public static WebDriver getDriver()
	{
		return tl.get();
	}
	
	public static void setDriver(WebDriver driver)
	{
		tl.set(driver);
	}
	
	public static void removeDriver()
	{
		tl.remove();
	}
}
