package com.qa.pages;



import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	LoginPage loginpage;
	
	// Defining locators using Page Factory
	
	@FindBy(xpath = "//a[@href='https://www.qrious.co.nz/products/ubiquity']")
	WebElement logo;
	
	@FindBy (id= "username")
	WebElement username;
	
	@FindBy (id="password")
	WebElement password;
	
	@FindBy(xpath = "//span[contains(.,'Login')]")
	WebElement loginbtn;
	
	// Initializing the locators
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// Methods
	
    public boolean Validatelogo() 
	
	{
	return logo.isDisplayed();
    }
	
	public  HomePage Login (String userid, String pwd) 
	 {
		username.sendKeys(userid);	
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage();
		 
	 }
	
	public String ValidateLoginPageTitle()
	{
		return driver.getTitle();
		
	}
	
	

}
