package dataProvidersParallel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class LoginPage 
{
	public final By userNameTF = By.name("user_name");
	
	public final By passwordNameTF = By.name("user_password");
	
	public HomePage login(String username, String password)
	{
		Driver.getDriver().findElement(userNameTF).sendKeys(username);
		Driver.getDriver().findElement(passwordNameTF).sendKeys(password,Keys.ENTER);
		return new HomePage();
	}
}
