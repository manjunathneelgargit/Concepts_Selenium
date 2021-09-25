package listeners_5_ControllingScript;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImp implements ITestListener, ISuiteListener
{

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Before suite in listener");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("After suite in listener");
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Before method in listener");	
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("After method in listener");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("After method in listener : Failed and Attaching screenshots");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("After method in listener : Skipped and Ignored");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Before Test NG test tag in listener");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("After Test NG test tag in listener");
		
	}

}
