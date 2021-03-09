package pageObjects;

import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.Utilities;
import com.github.javafaker.Faker;

public class ItemPage {

	WebDriver driver;
	
	Faker faker = new Faker(new Locale("en-US"));

	public ItemPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	By createNewItem = By.cssSelector("button span[data-label='New']");

	By ItemCode = By.xpath("//div[@class='control-input']//input[@data-fieldname='item_code']");

	By ItemName = By.xpath("//div[@class='control-input']//input[@data-fieldname='item_name']");

	By OpeningStock = By.xpath("//div[@class='control-input']//input[@data-fieldname='opening_stock']");

	By SellingRate = By.xpath("//div[@class='control-input']//input[@data-fieldname='standard_rate']");

	By ItemGroup = By.xpath("//div[@class='control-input']//input[@data-fieldname='item_group']");

	By BtnSave = By.xpath("//button[text()='Save']");

	By columnItemName = By.xpath("//div[contains(@class,'form-group frappe-control input-max-width col')]//input[@data-fieldname='item_name']");

	By BtnRefresh = By.cssSelector("button[data-label='Refresh']");

	private String AllItemGroups = "All Item Groups";

	public void CreateNewItem() 
	{
 		Utilities.WaitTillPageLoad(driver);
		String itemName = faker.food().spice()+" "+faker.number().digit();
		Utilities.Click(driver,createNewItem);
		Utilities.SendKeys(driver, ItemCode, faker.food().ingredient()+" "+faker.number().digit());
		Utilities.SendKeys(driver, ItemName, itemName);
		Utilities.Clear(driver, ItemGroup);
		Utilities.SendKeys(driver, ItemGroup,AllItemGroups);
		Utilities.Click(driver, BtnSave);

		Utilities.Click(driver, columnItemName);
		Utilities.Clear(driver, columnItemName);
		Utilities.SendKeys(driver, columnItemName, itemName);

		Utilities.Click(driver, BtnRefresh);
		Utilities.Click(driver, BtnRefresh);

		String itemSearch = "//a[contains(text(),'"+itemName+"')]";
		Utilities.IsElementDisplayed(driver, By.xpath(itemSearch));
	}
}
