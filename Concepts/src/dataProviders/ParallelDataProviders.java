package dataProviders;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParallelDataProviders 
{
	ThreadLocal<WebDriver> tl = new ThreadLocal<>();
	public WebDriver getDriver()
	{
		return tl.get();
	}
	
	public void setDriver(WebDriver driver)
	{
		tl.set(driver);
	}
	
	public void cleanDriver()
	{
		tl.remove();
	}
	
	@BeforeMethod
	public void configBM()
	{
		WebDriver driver = new ChromeDriver();
		setDriver(driver);
		getDriver().get("http://localhost:8888/");
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	//https://www.youtube.com/watch?v=9CumxYJ-dDI
	@Test(dataProvider = "data")
	public void TestCase(String userName, String password)
	{
		getDriver().findElement(By.name("user_name")).sendKeys(userName);
		getDriver().findElement(By.name("user_password")).sendKeys(password);		
	}
	
	@DataProvider(parallel = true)//**************************
	public String[][] data()
	{
		String[][] data = new String[6][2];
		
		data[0][0] = "admin1";  data[0][1] = "manager";
		data[1][0] = "admin2";  data[1][1] = "manager";
		data[2][0] = "admin3";  data[2][1] = "manager";
		data[3][0] = "admin4";  data[3][1] = "manager";
		data[4][0] = "admin5";  data[4][1] = "manager";
		data[5][0] = "admin6";  data[5][1] = "manager";
		
		return data;
	}
	
	@AfterMethod
	public void configAM()
	{
//		getDriver().quit();
		cleanDriver();
	}
}
