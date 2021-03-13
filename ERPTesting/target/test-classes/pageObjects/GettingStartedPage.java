package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.Utilities;

public class GettingStartedPage  {

	WebDriver driver;
	
	public GettingStartedPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	By gettingStartedLink = By.cssSelector("a[href='#modules/Getting Started']");
	
	By itemLink = By.cssSelector("a[href='#List/Item'][class='link-content']");
	
	public void ClickOnGettingStarted() 
	{
	   Utilities.WaitTillPageLoad(driver);
	   Utilities.Click(driver, gettingStartedLink);
	}
	
	public void NavigateToItemModule() 
	{
       Utilities.Click(driver, itemLink);
	}
}
