package com.automation.framework.dataproviders;

import org.testng.annotations.*;

import com.automation.framework.utilities.AppUtility;

/*
 * Data provider class
 * */
public class TestDataProvider {

	@DataProvider(name = "facebookLoginCredentials")
	public static Object[][] facebookLoginCredentials() {
		Object[][] facbookCredential = AppUtility.getsExceldata("FacebookCredential");
		return facbookCredential;

	}

	@DataProvider(name = "UserReviewData")
	public static Object[][] UserReviewData() {
		Object[][] facbookCredential = AppUtility.getsExceldata("WalletHub");
		return facbookCredential;

	}

}
