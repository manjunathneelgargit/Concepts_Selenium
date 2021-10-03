package customAnnotation;

import com.aventstack.extentreports.MediaEntityBuilder;

public final class ExtentLogger 
{
	private ExtentLogger(){}

	//Pass logger with capture screenshot by default
	public static void pass(String logMessage)
	{
		if(FileUtils.getDataFromProperties("passedstepsscreenshot").equalsIgnoreCase("yes"))
		{
			//Attach screenshot
			ExtentConfig.getExtentTest().pass(logMessage, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(GenericLib.getBase64Image()).build());
		}
		else //Do not attach screenshot
		{
			ExtentConfig.getExtentTest().pass(logMessage);
		}
	}

	//Pass logger and we can control screenshot is needed or no 
	public static void pass(String logMessage, boolean isScreenshotNeeded)
	{
		if(FileUtils.getDataFromProperties("passedstepsscreenshot").equalsIgnoreCase("yes") && isScreenshotNeeded)
		{
			//Attach screenshot
			ExtentConfig.getExtentTest().pass(logMessage, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(GenericLib.getBase64Image()).build());
		}
		else //Do not attach screenshot
		{
			ExtentConfig.getExtentTest().pass(logMessage);
		}
	}

	//Fail logger with capture screenshot by default
	public static void fail(String logMessage)
	{
		if(FileUtils.getDataFromProperties("failedstepsscreenshot").equalsIgnoreCase("yes"))
		{
			//Attach screenshot with log message, exceptionName, stackTrace
			ExtentConfig.getExtentTest().fail(logMessage, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(GenericLib.getBase64Image()).build());
		}
		else //Do not attach screenshot
		{
			ExtentConfig.getExtentTest().fail(logMessage);
		}
	}

	//Fail logger and we can control screenshot is needed or no
	public static void fail(String logMessage, boolean isScreenshotNeeded)
	{
		if(FileUtils.getDataFromProperties("failedstepsscreenshot").equalsIgnoreCase("yes") && isScreenshotNeeded)
		{
			//Attach screenshot with log message, exceptionName, stackTrace
			ExtentConfig.getExtentTest().fail(logMessage, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(GenericLib.getBase64Image()).build());
		}
		else //Do not attach screenshot
		{
			ExtentConfig.getExtentTest().fail(logMessage);
		}
	}

	public static void skip(String logMessage)
	{
		if(FileUtils.getDataFromProperties("skippedstepsscreenshot").equalsIgnoreCase("yes"))
		{
			//Attach screenshot
			ExtentConfig.getExtentTest().skip(logMessage, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(GenericLib.getBase64Image()).build());
		}
		else //Do not attach screenshot
		{
			ExtentConfig.getExtentTest().skip(logMessage);
		}
	}	
}
