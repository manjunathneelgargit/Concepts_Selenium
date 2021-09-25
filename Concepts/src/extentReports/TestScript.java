package extentReports;

import org.testng.annotations.Test;

public class TestScript extends Base
{
	@Test
	public void testCase1()
	{
		ExtentConfig.createTest(getClass().getName());
		ExtentConfig.test.pass("Test Case 1 is passed ");
	}
}
