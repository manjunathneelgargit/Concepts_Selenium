package listeners_1_normal;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImp implements ITestListener, ISuiteListener
{

	@Override
	public void onStart(ISuite suite) 
	{
		System.out.println("Suite execution started");
	}

	@Override
	public void onFinish(ISuite suite) 
	{
		System.out.println("Suite execution completed");		
	}

	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println("Script execution started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("Script execution completed successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Script execution Failed");		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("Script execution skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
