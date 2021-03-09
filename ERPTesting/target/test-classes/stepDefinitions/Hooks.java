package stepDefinitions;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	TestContext testContext;
	
	public Hooks(TestContext context)
	{
		testContext = context;
	}
		
	@Before
	 public void beforeScenario(Scenario scenario) {
	     System.out.println("Execution started for scenario "+scenario.getName());
	 }
	
	@After(order=1)
	public void AttachScreenshot(Scenario scenario)
	{
		Date objNewDateFolder = new Date();
		SimpleDateFormat dateFormat_Folder = new SimpleDateFormat("dd_MM_YYYY");
		
		if(scenario.isFailed())
		{
			final byte[] screenshot = ((TakesScreenshot)testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot,"image/png", scenario.getName()+ ""+dateFormat_Folder.format(objNewDateFolder));
			System.out.println("Scenario "+scenario.getName()+ "failed");
		}
		else
		{
			final byte[] screenshot = ((TakesScreenshot)testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot,"image/png", scenario.getName()+ ""+dateFormat_Folder.format(objNewDateFolder));
			System.out.println("Scenario "+scenario.getName()+ " passed");
		}
		testContext.getWebDriverManager().closeDriver();
	}
	
}
