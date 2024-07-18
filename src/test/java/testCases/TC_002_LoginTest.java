package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{

	@Test	
	public void verify_login()
	{
		logger.info("****Starting TC_002_LoginTest ****");
		
		try {
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmailAddress(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.ClickLogin();
		
		//MyAccount
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyaccountPageExists();
		
//		Assert.assertEquals(targetPage, true, "Login Failed");
		Assert.assertTrue(targetPage);
		}
		catch (Exception e ) {
			Assert.fail();
		}
		logger.info("****** Finished TC_002_LoginTest *****");
		
		
	}
}
