package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.HomePage;
import cucumber.*;

public class HomePageSteps {

	TestContext testContext;
	HomePage homePage;

	public HomePageSteps(TestContext context)
	{
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
	}
    
	@Given("^User is on home page$")
	public void UserOnHomePage()
	{
		homePage.NavigateToHomePage();
	}

	@Then("^User logs in with valid credentials with username (.*) and password (.*)$")
	public void Login(String username,String password)
	{
		homePage.Login(username, password);
	}
}
