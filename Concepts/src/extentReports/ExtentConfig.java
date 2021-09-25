package extentReports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//This class is final because no one should extend it
public final class ExtentConfig 
{
	private ExtentConfig() {} //This is because no one should create object for this

	private static ExtentReports extent;
	public static ExtentTest test; //This variable can be used to to create a logs in scripts
	
	public static void extentConfig()
	{
		if(Objects.isNull(extent))
		{
			System.out.println("Configuring Extent Reports");
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("./src/extentReports/Report.html"); //path and name of report file
			extent.attachReporter(spark);

			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Automation Report"); //HTML title
			spark.config().setReportName("Name of report");
		}
	}

	public static void createTest(String testCaseName)
	{
		 test = extent.createTest(testCaseName);
	}

	public static void flushExtentReport()
	{
		if(Objects.nonNull(extent))
		{
			extent.flush();
		}
	}
}
