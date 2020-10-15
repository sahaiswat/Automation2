package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	
LoginPage loginPage;
TestUtil testutil;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		testutil= new TestUtil();
		loginPage= new LoginPage();
	}
	
	@Test(priority=1, description = "Verify the logo is displayed")
	
	public void LogoisDisplayed()
	{
		Boolean flag=loginPage.Validatelogo();
		Assert.assertTrue(flag);
	}

     @Test(priority=2, description = "Verify login Page Title is displayed")
     public void LoginPageTitleTest()
    {
	String title=loginPage.ValidateLoginPageTitle();
	Assert.assertEquals(title, "UbiQuity - QATest", "Loginpage title not matched");
    }
	
	@Test(priority=3, description = "Verify user is able to login")
	public void LoginTest()
	{

		loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
		
	@AfterMethod
	public void CloseApplication()
	{
		TearDown();
	}
	
	
	
	

}
