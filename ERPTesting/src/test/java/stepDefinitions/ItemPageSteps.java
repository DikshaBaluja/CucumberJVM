package stepDefinitions;

import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import pageObjects.ItemPage;

public class ItemPageSteps {

	TestContext testContext;
	ItemPage itemPage;
	
	public ItemPageSteps(TestContext context)
	{
		testContext = context;
		itemPage = testContext.getPageObjectManager().getItemPage();
	}
	
	@Then("^User creates new item$")
	public void GettingStarted() 
	{
		itemPage.CreateNewItem();
	}
	
	@Then("^User stores newly created Item Name$")
	public void GetItemName()
	{
		 String itemName = itemPage.getItemName();
		 testContext.scenarioContext.setContext(Context.ITEM_NAME,itemName);
	}
}
