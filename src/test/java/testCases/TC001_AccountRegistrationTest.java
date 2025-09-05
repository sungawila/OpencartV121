package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {


	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {

		logger.info("Starting TC001_AccountRegistrationTest");

		try {
			HomePage hp = new HomePage(driver);

			hp.clickMyAccount();
			logger.info("Clicked on My Account link");

			hp.clickRegister();
			logger.info("Clicked on Register link");

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			logger.info("Providing user details");

			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());

			regpage.setEmail(randomString()+"@gmail.com");
			regpage.setTelephoneNo(randomNumber());

			String password =randomAlphaNumeric();

			regpage.setPassword(password);
			regpage.setConfirmPassword(password);

			regpage.setPrivacyPolicy();
			regpage.clickContinue();

			logger.info("Validating expected message");
			String confirmMessage = regpage.getConfirmationMessage();

			if(confirmMessage.equals("Your Account Has Been Created!")) {

				Assert.assertTrue(true);
			}
			else {
				logger.error("Test failed");
				logger.debug("Debug logs");
				Assert.assertTrue(false);
			}


			//Assert.assertEquals(confirmMessage, "Your Account Has Been Created!");
		}
		catch(Exception e) {


			Assert.fail();
		}

		logger.info("Finished TC001_AccountRegistrationTest");

	}


}
