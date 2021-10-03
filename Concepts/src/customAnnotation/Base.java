package customAnnotation;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import driverManager.Driver;
public class Base 
{

	private WebDriver driver;
	
	@BeforeClass public void configBC() { System.out.println("Before Class"); }

	@BeforeMethod 
	public void configBM() 
	{ 
		driver = new ChromeDriver();
		Driver.setDriver(driver);
		Driver.getDriver().get("http://localhost:8888");
	}

	@AfterMethod 
	public void configAM(Method m, ITestResult result) 
	{ 
		Driver.getDriver().quit();
	}

	@AfterClass public void configAC() { System.out.println("After Class"); }

}
