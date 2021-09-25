package dataProvidersParallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Base 
{
	public static WebDriver driver;
	public static HomePage hp;
	
	@BeforeSuite
	public void configBS(){ System.out.println("Config Before Suite"); }

	
	@BeforeMethod
	public void configBM()
	{
		System.out.println("Config Before Class");
		driver = new ChromeDriver();
		Driver.setDriver(driver);
		Driver.getDriver().get("http://localhost:8888");
		hp = new LoginPage().login("admin", "manager");
	}
	
	@AfterMethod
	public void configAM()
	{
		Driver.getDriver().quit();
		Driver.cleanDriver();
	}
}
