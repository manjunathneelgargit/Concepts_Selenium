package listeners_RetryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer
{
	//Whenever a test is failed then this method will be called
	//If this method returns true, then the failed method will be run
	//By default this method will return false, indicating no need to run failed method
	
	int counter = 0;
	int limit = 1;
	
	@Override
	public boolean retry(ITestResult result) 
	{
		if(counter<limit)
		{
			counter++;
			return true;
		}
		else 
		{
			return false;
		}
	}

}
