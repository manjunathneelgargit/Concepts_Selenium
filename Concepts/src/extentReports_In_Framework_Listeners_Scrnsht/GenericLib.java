package extentReports_In_Framework_Listeners_Scrnsht;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driverManager.Driver;

public class GenericLib 
{
	//Take Screenshot as BASE64 method
	public static String getBase64Image()
	{
		return ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
