package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDTT extends BaseClass {

	// Data is valid - login success - test pass - logout
	// Data is valid - login failed -test fail

	// Data is invalid - login success - test fail - logout
	// Data is invalid -login failed - test pass
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class) // getting data provider from another
																				// class
	public void verify_loginDTT(String email, String pwd, String exp) throws InterruptedException {

		logger.info("**** starting TC_003_LoginDDT ****");

		try {
			// HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.setEmailAddress(email);
			lp.setPassword(pwd);
			lp.ClickLogin();

			// MyAccount
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyaccountPageExists();

			if (exp.equalsIgnoreCase("Valid")) {
				if (targetPage == true) {
					Assert.assertTrue(true);
					macc.ClickLogout();
				} else {
					Assert.assertTrue(false);
				}

			}
			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetPage == true) {
					macc.ClickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		Thread.sleep(5000);
		logger.info("**** Finished TC_003_LoginDDT ****");

	}

}
