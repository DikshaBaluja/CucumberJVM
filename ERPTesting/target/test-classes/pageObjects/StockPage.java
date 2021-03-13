package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import selenium.Utilities;

public class StockPage {

	WebDriver driver;
	
	public StockPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	By StockModuleNavigationLink = By.cssSelector("a[href='#modules/Stock']");
	
	By ItemLink = By.xpath("//span[@class='indicator blue']/following-sibling::a[@href='#List/Item']");
	
	By columnItemName = By.xpath("//div[contains(@class,'form-group frappe-control input-max-width col')]//input[@data-fieldname='item_name']");

	By BtnRefresh = By.cssSelector("button[data-label='Refresh']");
	
	public void ClickOnStockLink()
	{
		Utilities.Click(driver, StockModuleNavigationLink);
	}
	
	public void ClickOnItemLink()
	{
		Utilities.Click(driver, ItemLink);
	}
	
	public void VerifyNewlyCreatedItem(String itemName) 
	{
		Utilities.ClickUsingAction(driver, columnItemName);
		Utilities.Clear(driver, columnItemName);
		Utilities.SendKeys(driver, columnItemName, itemName);

		Utilities.Click(driver, BtnRefresh);
		Utilities.Click(driver, BtnRefresh);

		String itemSearch = "//a[contains(text(),'"+itemName+"')]";
		Utilities.IsElementDisplayed(driver, By.xpath(itemSearch));
	}
}
