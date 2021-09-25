package extentReports_In_Framework;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
public class Base 
{

	@BeforeSuite
	public void configBS()
	{
		ExtentConfig.extentConfig();
	}

	@BeforeClass public void configBC() { System.out.println("Before Class"); }

	@BeforeMethod 
	public void configBM(Method m) 
	{ 
		ExtentConfig.createTest(m.getName());
		System.out.println("Before Method"); 
	}

	@AfterMethod 
	public void configAM(Method m, ITestResult result) 
	{ 
		System.out.println("After Method");
		if(result.isSuccess())
		{
			System.out.println(m.getName()+" Script Executed Successfully");
		} 
	}

	@AfterClass public void configAC() { System.out.println("After Class"); }

	@AfterSuite public void configAS() 
	{ 
		ExtentConfig.flushExtentReport();
	}
}
