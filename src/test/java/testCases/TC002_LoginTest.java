package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		
		try
		{
		logger.info("Starting TC002_LoginTest");
		
		//Home Page
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login Page
		LoginPage lp = new LoginPage(driver);
		
		lp.setEmail(p.getProperty("email")); //Reading from property
		lp.setPassword(p.getProperty("password")); //Reading from property
		lp.clickLogin();
		
		//My Account Page
		MyAccountPage map = new MyAccountPage(driver);
		boolean tragetPageTitle = map.isMyAccountPageExists();
		
		//Assert.assertEquals(tragetPageTitle, true,"Login failed");
		Assert.assertTrue(tragetPageTitle);
		
		logger.info("Finished TC002_LoginTest");
		
		}
		catch(Exception e) {
			
			Assert.fail();
			
		}
		
	}
	

}
