package webDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Runner {

	public static void main(String[] args) {
		
//		WebDriverManager.chromedriver().clearResolutionCache().setup();
		WebDriverManager.chromedriver().setup(); //Set up chromedriver
		WebDriver driverChrome = new ChromeDriver(); //Launch chrome browser
		
		WebDriverManager.firefoxdriver().setup(); //Set up firefoxdriver
		WebDriver driverFirefox = new FirefoxDriver(); //Launch chrome browser
	}
	

}
