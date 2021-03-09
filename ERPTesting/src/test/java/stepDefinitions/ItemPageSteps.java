package stepDefinitions;

import cucumber.TestContext;
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
	public void GettingStarted() throws Exception
	{
		itemPage.CreateNewItem();
	}
}
