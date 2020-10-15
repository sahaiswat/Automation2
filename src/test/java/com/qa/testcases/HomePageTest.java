
	package com.qa.testcases;


	
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import com.qa.base.TestBase;

import com.qa.pages.HomePage;
	import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

	public class HomePageTest extends TestBase{
		
		LoginPage loginPage;
	    HomePage homePage;
	    TestUtil testutil;
	  
	    public HomePageTest()
		{
			super();
		}

	
		@BeforeMethod
		public void setUp()
		{
			initialization();
			testutil= new TestUtil();
			loginPage= new LoginPage();
			homePage=loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
			}
		
		@Test(priority=1, description = "Verify the logo is displayed")
		public void ValidateTextisDisplayed()
		{		
			Assert.assertEquals(homePage.ValidateText(), "                    Welcome to the Ubiquity Tester admin page.");	
			
		}
		
		@Test(priority=2, description = "Verify the Image is displayed")
		public void ValidateImageisDisplayed()
		{

			Assert.assertTrue(homePage.ValidateImage(),"Image is displayed");	
			
		}
		
		@Test(priority=3, description = "Verify the edit profile page label is displayed ")
		public void ValidateLabelisDisplayed()
		{
			
			Assert.assertTrue(homePage.ValidateLabel(),"Label is displayed");	
			
		}
		
		@Test(priority=4, description = "Verify user can go to edit profile page successfully")
		public void ValidateUserisonEditProfilePage() throws InterruptedException 
		{
			
			homePage.ClickonEditButton();
			
		}
	
		@Test(priority=5, description = "Verify user can logout successfully")
		public void ValidateUserisLoggedOut() throws InterruptedException
		{
			homePage=new HomePage();
			homePage.ClickonLogoutButton();
			
		}
		
		
		
		@AfterMethod
		public void CloseApplication()
		{
			TearDown();
		}

	}



