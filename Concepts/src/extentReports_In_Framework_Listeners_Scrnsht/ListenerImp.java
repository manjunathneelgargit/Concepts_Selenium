package extentReports_In_Framework_Listeners_Scrnsht;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImp implements ITestListener, ISuiteListener
{
	
	//This is like @BeforeSuite
	@Override
	public void onStart(ISuite arg0) {
		ExtentConfig.extentConfig();		
	}
	
	//This is like @AfterSuite
	@Override
	public void onFinish(ISuite arg0) {
		ExtentConfig.flushExtentReport();
	}

	//This is like @BeforeMethod
	@Override
	public void onTestStart(ITestResult result) 
	{
		ExtentConfig.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		ExtentLogger.pass(result.getMethod().getMethodName()+" script is PASSED");
	}
	
	
	@Override
	public void onTestFailure(ITestResult result) 
	{
		String logMessString = result.getMethod().getMethodName()+" script is FAILED";
		String exceptionName = result.getThrowable().toString();
		String stackTrace = Arrays.toString(result.getThrowable().getStackTrace());
		ExtentLogger.fail("Log Message : "+logMessString);
		ExtentLogger.fail("Exception Name : "+exceptionName,false);
		ExtentLogger.fail("Stack Trace : "+stackTrace,false);
	}
	
	@Override
	public void onTestSkipped(ITestResult result) 
	{
		ExtentLogger.skip(result.getMethod().getMethodName()+" script is SKIPPED");
	}
	
	@Override
	public void onFinish(ITestContext arg0) {
		/**
		 * For now we are not using this method
		 */
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		/**
		 * For now we are not using this method
		 */
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		/**
		 * For now we are not using this method
		 */		
	}

		


}
