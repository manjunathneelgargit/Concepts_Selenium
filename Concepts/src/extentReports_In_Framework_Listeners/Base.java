package extentReports_In_Framework_Listeners;

import java.lang.reflect.Method;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
public class Base 
{

	@BeforeClass public void configBC() { System.out.println("Before Class"); }

	@BeforeMethod 
	public void configBM() 
	{ 
		
	}

	@AfterMethod 
	public void configAM(Method m, ITestResult result) 
	{ 
		
	}

	@AfterClass public void configAC() { System.out.println("After Class"); }

}
