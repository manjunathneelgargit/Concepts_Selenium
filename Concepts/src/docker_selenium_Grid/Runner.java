package docker_selenium_Grid;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Runner {

	@Test(dataProvider = "browsers")
	public void runInDocker1(String browser) throws MalformedURLException, InterruptedException {
	
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(browser);
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		driver.get("https://www.testyantra.com");
		Thread.sleep(5000);
		System.out.println(browser+" => "+driver.getTitle());
		driver.quit();
	}
	
	@DataProvider(parallel=true)
	public String[] browsers() {
		String[] browsers = {"chrome","firefox","chrome","firefox"};
		return browsers;
	}
	
}
