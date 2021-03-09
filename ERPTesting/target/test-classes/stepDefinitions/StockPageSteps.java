package stepDefinitions;

import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import pageObjects.StockPage;
import selenium.Utilities;

public class StockPageSteps {

	TestContext testContext;
	StockPage stockPage;

	public StockPageSteps(TestContext context) {
		testContext = context;
		stockPage = testContext.getPageObjectManager().stockPage();
	}

	@Then("^User navigates to Item module through stock module$")
	public void NavigateToItemThroughStockModule()
	{
		stockPage.ClickOnStockLink();
		stockPage.ClickOnItemLink();
	}

	@Then("^User verifies newly created item through stock module$")
	public void UserVerifiesNewlyCreatedItemThroughStockModule()
	{
		String itemName = (String)testContext.scenarioContext.getContext(Context.ITEM_NAME);
        stockPage.VerifyNewlyCreatedItem(itemName); 
	}
}
