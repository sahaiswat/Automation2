package com.qa.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class HomePage extends TestBase{
	
	HomePage homePage;
	TestUtil testutil;
	
	// Defining locators using Page Factory
		
	
	@FindBy(xpath = "//ul[@id='fields']//h1//strong//span//span[contains(normalize-space(),'Welcome to the Ubiquity Tester admin page.')]")
	WebElement text;
	
	
	@FindBy(xpath="//span[contains(normalize-space(),'Edit Profile')]")
	WebElement Editbutton;
	
	
	@FindBy(xpath="//span[contains(normalize-space(),'Logout')]")
	WebElement logoutbtn;
	
	@FindBy(xpath = "//img[@border='0']")
	WebElement image;
	
	@FindBy(xpath = "//p[@class='label']")
	WebElement label;
	
	@FindBy(xpath = "//p[contains(normalize-space(),'Please enter your details below.')]")
	WebElement landingtext;
	
	// Initializing the locators
	
	public HomePage() 
		
		{
			PageFactory.initElements(driver, this);
		}
		
	// Methods
	
		public String ValidateText() 
		{
			
			String txt= text.getText();			
			return txt;
					
		}
		
		public boolean ValidateImage()
		{
			return image.isDisplayed();
		}
		
		public boolean ValidateLabel()
		{
			return label.isDisplayed();
		}
		
		public EditProfilePage ClickonEditButton() throws InterruptedException 
				{
			
			Thread.sleep(3000);
		    Editbutton.click();
			return new EditProfilePage();
			
			
		}
			
		public void ClickonLogoutButton() throws InterruptedException
		{
			Thread.sleep(3000);
			logoutbtn.click();
			
		}
		
		
	}



