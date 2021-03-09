package managers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import enums.DriverType;
import enums.EnvironmentType;

public class WebDriverManager {

	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	public WebDriverManager()
	{
		driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigFileReader().getEnvironment();
	}

	public WebDriver getDriver()
	{
		if(driver==null) driver = CreateDriver();
		return driver;
	}

	public WebDriver CreateDriver()
	{
		switch(environmentType)
		{
		case LOCAL : driver = createLocalDriver();
		break;
		case REMOTE : driver = createRemoteDriver();
		}
		return driver;
	}

	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	private WebDriver createLocalDriver()
	{
		switch(driverType)
		{
		case FIREFOX : driver = new FirefoxDriver();
		break;
		case CHROME :
			System.setProperty(CHROME_DRIVER_PROPERTY,FileReaderManager.getInstance().getConfigFileReader().getDriverPath()); 	  
			driver = new ChromeDriver();
			break;
		default:
			Assert.fail("Invalid driver type "+driverType);
			break;
		} 
        if(FileReaderManager.getInstance().getConfigFileReader().getBrowserWindowSize())
        {
        	driver.manage().window().maximize();
        }
        return driver;
	}
	
	public void closeDriver()
	{
	  driver.quit();
	}

}
