package extentReports;

import org.testng.annotations.Test;

public class Script extends Base
{
	@Test
	public void testScript()
	{
		ExtentConfig.createTest(getClass().getName());
		ExtentConfig.test.pass("Test Script is passed");
	}
}
