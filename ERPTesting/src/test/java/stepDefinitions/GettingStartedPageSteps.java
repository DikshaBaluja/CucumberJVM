package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Then;
import pageObjects.GettingStartedPage;


public class GettingStartedPageSteps {

	TestContext testContext;
	GettingStartedPage gettingStartedPage;

	public GettingStartedPageSteps(TestContext context)
	{
		testContext = context;
		gettingStartedPage = testContext.getPageObjectManager().getGettingStartedPage();
	}
    
	@Then("^User clicks on Getting Started$")
	public void GettingStarted() throws Exception
	{
		gettingStartedPage.ClickOnGettingStarted();
	}
	
	@Then("^User navigates to Item Module$")
	public void NavigateToItemModule() throws Exception
	{
		gettingStartedPage.NavigateToItemModule();
	}
}
