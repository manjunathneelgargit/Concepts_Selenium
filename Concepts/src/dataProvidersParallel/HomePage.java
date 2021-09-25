package dataProvidersParallel;

import org.openqa.selenium.By;


public class HomePage 
{
	public By contactsLink = By.linkText("Contacts");
	
	public By createContactImg = By.xpath("//img[@alt='Create Contact...']");

	public By firstNameTF = By.name("firstname");
	
	public By lastNameTF = By.name("lastname");

	public By saveButton = By.xpath("//input[@title='Save [Alt+S]']");


	public void createContact(String firstName, String lastName)
	{
		Driver.getDriver().findElement(contactsLink).click();
		Driver.getDriver().findElement(createContactImg).click();
		Driver.getDriver().findElement(firstNameTF).sendKeys(firstName);
		Driver.getDriver().findElement(lastNameTF).sendKeys(lastName);
		Driver.getDriver().findElement(saveButton).click();
	}

}
