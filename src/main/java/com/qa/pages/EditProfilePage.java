package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class EditProfilePage extends TestBase{
	
	// Defining locators using Page Factory
	
	
	@FindBy(xpath = "//img[@src='images/ubiquity_coral_half.png']")
	WebElement logo;
	
	@FindBy(xpath = "//p[contains(normalize-space(),'Please enter your details below.')]")
	WebElement landingtext;
	
	@FindBy(xpath = "//span[contains(normalize-space(),'Home')]")
	WebElement homepagebutton;
   
	@FindBy(xpath = "//input[@class='textfield email']")
	WebElement emailid;
	
	@FindBy(xpath = "//input[@class='textfield mobilenumber']")
	WebElement mobilenumber;
	
	@FindBy(xpath = "//input[@class='textfield date']")
	WebElement dob;
	
	@FindBy(xpath = "(//input[@type='Password'])[1]")
	WebElement newpassword;
	
	@FindBy(xpath = "(//input[@type='Password'])[2]")
	WebElement confirm;
	
	@FindBy(xpath = "//button[contains(.,'Submit')]")
	WebElement submitbtn;
	
	@FindBy(xpath = "//p[@id='SuccessMessage']")
	WebElement successmsg;

	// Initializing the locators
	
	public EditProfilePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// Methods
	
   public boolean Validatelogo() 
	
	{
	return logo.isDisplayed();
    }
   
   public String ValidateText() 
	{
		
		String txt= landingtext.getText();			
		return txt;
				
	}
	
	
	public  String UpdateInfo(String emailadd, String mobil, String dob1, String newpassid, String confirmid)
	{
		emailid.sendKeys(emailadd);
		mobilenumber.sendKeys(mobil);
		dob.sendKeys(dob1);
		newpassword.sendKeys(newpassid);
		confirm.sendKeys(confirmid);
		submitbtn.click();
		String txt1=successmsg.getText();
		return txt1;
				
	}
	
	
	
	

}
