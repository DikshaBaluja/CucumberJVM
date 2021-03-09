package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.GettingStartedPage;
import pageObjects.HomePage;
import pageObjects.ItemPage;
import pageObjects.StockPage;

public class PageObjectManager {

	private WebDriver driver;
	
	private HomePage homePage;
	
	private GettingStartedPage gettingStartedPage;
	
	private ItemPage itemPage;
		
	private StockPage stockPage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
		
	public HomePage getHomePage()
	{
		return (homePage==null)?homePage = new HomePage(driver):homePage;	
	}
	
	public GettingStartedPage getGettingStartedPage()
	{
		return (gettingStartedPage==null)?gettingStartedPage = new GettingStartedPage(driver):gettingStartedPage;	
	}
	
	public ItemPage getItemPage()
	{
		return (itemPage==null)?itemPage = new ItemPage(driver):itemPage;	
	}
	
	public StockPage stockPage()
	{
		return (stockPage==null)?stockPage = new StockPage(driver):stockPage;	
	}
}
