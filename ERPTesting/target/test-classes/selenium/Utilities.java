package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utilities{ 

	public static void WaitForElementToBeClickable(WebDriver driver,By locator)
	{   
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void WaitForElementToBeVisible(WebDriver driver,By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void Click(WebDriver driver,By locator)
	{
		WaitForElementToBeVisible(driver, locator);
		WaitForElementToBeClickable(driver, locator);
		driver.findElement(locator).click();
	}
	
	public static void ClickUsingAction(WebDriver driver,By locator)
	{
		WaitForElementToBeVisible(driver, locator);
		WaitForElementToBeClickable(driver, locator);
		WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public static void SendKeys(WebDriver driver,By locator,String text)
	{
		WaitForElementToBeVisible(driver, locator);
		WaitForElementToBeClickable(driver, locator);
		driver.findElement(locator).sendKeys(text);
	}

	public static void Clear(WebDriver driver,By locator)
	{
		WebElement element=driver.findElement(locator);
		WaitForElementToBeVisible(driver, locator);
		WaitForElementToBeClickable(driver, locator);
		element.clear();
	}

	public static void IsElementDisplayed(WebDriver driver,By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void WaitTillPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Constants.SHORT_WAIT,TimeUnit.SECONDS);
	}
	
	public static String GetText(WebDriver driver,By locator)
	{
		WebElement element=driver.findElement(locator);
		WaitForElementToBeVisible(driver, locator);
		return element.getText();
	}
}
