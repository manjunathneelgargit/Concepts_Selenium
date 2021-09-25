package extentReports_In_Framework_Listeners;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//This class is final because no one should extend it
public final class ExtentConfig 
{
	//This is because no one should create object for this
	private ExtentConfig() {}
	
	private static ExtentReports extent;
	
	//Thread safety for ExtentTest object
	private static ThreadLocal<ExtentTest> tl = new ThreadLocal<>();
	
	//Keep these methods as default modifier(not specifying any modifier), so that these can be accessed only within the package
	static ExtentTest getExtentTest()
	{
		return tl.get();
	}
	
	static void setExtentTest(ExtentTest test)
	{
		tl.set(test);
	}
	
	static void removeExtentTest() {
		tl.remove();
	}
	
	//To configure extent reports. Call this method in @BeforeSuite
	public static void extentConfig()
	{
		if(Objects.isNull(extent))
		{
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("./src/extentReports_In_Framework_Listeners/Report.html"); //path and name of report file
			extent.attachReporter(spark);

			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Automation Report"); //HTML title
			spark.config().setReportName("Name of report"); //This name will be displayed inside the report at right top corner
		}
	}

	//To create a entry of script in extent reports. This method will be called in every scripts
	public static void createTest(String testCaseName)
	{
		 ExtentTest test = extent.createTest(testCaseName);
		 setExtentTest(test); //Insert ExtentTest object in ThreadLocal object
	}

	//This method need to be called in @AfterSuite once the execution is completed in order to push all the reports in html page
	public static void flushExtentReport()
	{
		if(Objects.nonNull(extent))
		{
			extent.flush();
		}
	}
}
