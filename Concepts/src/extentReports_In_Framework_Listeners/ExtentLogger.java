package extentReports_In_Framework_Listeners;

public final class ExtentLogger 
{
	private ExtentLogger(){}
	
	public static void pass(String logMessage)
	{
		ExtentConfig.getExtentTest().pass(logMessage);
	}
	
	public static void fail(String logMessage)
	{
		ExtentConfig.getExtentTest().fail(logMessage);
	}
	
	public static void skip(String logMessage)
	{
		ExtentConfig.getExtentTest().skip(logMessage);
	}
	
}
