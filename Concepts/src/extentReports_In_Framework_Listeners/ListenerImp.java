package extentReports_In_Framework_Listeners;

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
		ExtentLogger.fail(result.getMethod().getMethodName()+" script is FAILED");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) 
	{
		ExtentLogger.skip(result.getMethod().getMethodName()+" script is SKIPPED");
	}
	
	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

		


}
