package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.EditProfilePage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class EditProfilePageTest extends TestBase{
	
	LoginPage loginPage;
    HomePage homePage;
    TestUtil testutil;
	EditProfilePage editprofile;
	String sheetname="details";
	
	
	public EditProfilePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		testutil= new TestUtil();
		loginPage= new LoginPage();
		homePage=loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		editprofile=homePage.ClickonEditButton();
		
		
	}
	
	@Test(priority=1, description = "Verify the landingtext is displayed ")
	public void VerifyTextisDisplayed()
	{
		System.out.print(editprofile.ValidateText());
		Assert.assertEquals(editprofile.ValidateText(), "Please enter your details below.");
		
	}
	
	@Test(priority=2, description = "Verify the logo is displayed ")
	public void VerifyLogoisDisplayed()
	{
		Boolean flag=editprofile.Validatelogo();
		Assert.assertTrue(flag);
	}
	
	@DataProvider
	public Object[][] EditDetails()
	{
	Object data[][]=TestUtil.getTestData(sheetname);
	return data;
	}
	
	
	
	@Test(priority=3, dataProvider="EditDetails", description = "Verify updated info shows on the page")
	public void EditDetailsTest(String emailadd, String mobil, String dob1, String newpassid, String confirmid)
	{
		editprofile.UpdateInfo(emailadd, mobil, dob1, newpassid, confirmid);	
		System.out.print(editprofile.UpdateInfo(emailadd, mobil, dob1, newpassid, confirmid));
		Assert.assertEquals(editprofile.UpdateInfo(emailadd, mobil, dob1, newpassid, confirmid), "Update is successful! Please see updated information below");
		
	}
	
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
	

}
