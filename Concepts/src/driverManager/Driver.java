package driverManager;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver 
{
	//*********************** Thread Safety code *************************
	private static ThreadLocal<WebDriver> tl = new ThreadLocal<>();
	
	public static WebDriver getDriver()
	{
		return tl.get();
	}
	
	public static void setDriver(WebDriver driver)
	{
		tl.set(driver);
	}
	
	public static void removeDriver()
	{
		tl.remove();
	}
	
	//*********************** Initialize and quit driver *************************
	public static void initDriver()
	{
		if(Objects.isNull(getDriver()))
		{
			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		}
		setDriver(new ChromeDriver());
		getDriver().get("http://localhost:8888");
	}
	
	public static void quitDriver()
	{
		if(Objects.nonNull(getDriver()))
		{
			getDriver().quit();
			removeDriver();
		}
	}
}
