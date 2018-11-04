package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.framework.dataproviders.TestDataProvider;
import com.automation.framework.facebookpages.FacebookLoginPage;
import com.automation.framework.utilities.AppUtility;

public class FacebookLoginPageTest extends TestBase {

	public FacebookLoginPageTest() {
		super();
	}

	@BeforeClass
	public void confURL() {
		setup();
		getFacebookURL();

	}

	@Test(dataProvider = "facebookLoginCredentials", dataProviderClass = TestDataProvider.class)
	public void facbookLogin(String emailFB, String passwordFB) {

		fbLogin = new FacebookLoginPage();
		fbHome = fbLogin.logIn(emailFB, AppUtility.decodePassword(passwordFB));
		Assert.assertTrue(fbHome.homeButtonPresent());
		System.out.println("Hello World");

	}

}
