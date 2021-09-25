package threadSafety;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Script 
{
	WebDriver driver;

	
	@BeforeClass
	public void bc()
	{
		System.out.println("Script before class");
		driver = new ChromeDriver();
		ThreadSafety.setDriver(driver);
		ThreadSafety.getDriver().get("http://localhost:8888");
	}
	
	@BeforeMethod public void bm()
	{
		System.out.println("Script before Method");
	}
	
	@AfterMethod public void am()
	{
		System.out.println("Script after method");
	}
	
	@AfterClass
	public void ac()
	{
		ThreadSafety.getDriver().quit();
		ThreadSafety.cleanDriver();
	}
	
	@Test public void testCase1() {System.out.println("Test Case 1");};
	
	@Test public void testCase2() {System.out.println("Test Case 2");};
	
	@Test public void testCase3() {System.out.println("Test Case 3");};
	
}
