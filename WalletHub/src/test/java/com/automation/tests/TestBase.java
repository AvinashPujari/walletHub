package com.automation.tests;

import org.testng.annotations.AfterClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.automation.framework.base.Base;
import com.automation.framework.facebookpages.FacebookHomePage;
import com.automation.framework.facebookpages.FacebookLoginPage;
import com.automation.framework.wallethubpages.ReviewHomePage;
import com.automation.framework.wallethubpages.WalletHubLoginPage;
import com.automation.framework.wallethubpages.WriteReviewPage;

/*
 * Base class for common items
 * 
 * 
 * 
 * 
 * */

public class TestBase extends Base {

	FacebookLoginPage fbLogin;
	FacebookHomePage fbHome;
	WalletHubLoginPage walletHubLoginPage;
	ReviewHomePage reviewHomePage;
	WriteReviewPage writeReviewPage;

	public TestBase() {
		super();
	}

	@AfterMethod
	public void testTeardown() {
		driver.quit();
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

	@BeforeSuite()
	public void setupGlobal() {
		// reporting and logs
	}

	@AfterSuite()
	public void teardownGlobal() {
	}
}
