package dataProvidersParallel;

import org.openqa.selenium.WebDriver;

public class Driver 
{
	public static ThreadLocal<WebDriver> tl = new ThreadLocal<>();
	public static WebDriver getDriver()
	{
		return tl.get();
	}
	
	public static void setDriver(WebDriver driver)
	{
		tl.set(driver);
	}
	
	public static void cleanDriver()
	{
		tl.remove();
	}
}
