package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import dataProvider.ConfigFileReader;
import managers.FileReaderManager;
import selenium.Utilities;

public class HomePage {
    WebDriver driver;
    ConfigFileReader configFileReader;
    
    public HomePage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
    	configFileReader= new ConfigFileReader();
    }
    
    By loginLink = By.linkText("Login");
    
    By loginUsername = By.id("login_email");
    
    By loginPassword = By.id("login_password");
        
    public void NavigateToHomePage()
    {
       driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationUrl());
    }
    
    public void Login(String username,String password)
    {
       Utilities.Click(driver, loginLink);	
       Utilities.SendKeys(driver, loginUsername, username);
       Utilities.SendKeys(driver,loginPassword,password+Keys.ENTER);
    }
}
