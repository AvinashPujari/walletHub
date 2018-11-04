package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.framework.dataproviders.TestDataProvider;
import com.automation.framework.utilities.AppUtility;
import com.automation.framework.wallethubpages.WalletHubLoginPage;

public class WalletHubReviewTest extends TestBase {

	public WalletHubReviewTest() {
		super();
	}

	@BeforeClass
	public void confURL() {
		setup();
		getWalletHubURL();
	}

	@Test(dataProvider = "UserReviewData", dataProviderClass = TestDataProvider.class)
	public void reviewTest(String emailID, String password, String starRating, String policyDropdown,
			String reviewContent) {
		walletHubLoginPage = new WalletHubLoginPage();
		reviewHomePage = walletHubLoginPage.login(emailID, AppUtility.encodePassword(password));
		reviewHomePage.closeFooterAd();
		reviewHomePage.mouseHoverOnRatingLabel();
		System.out.println(starRating);
		Assert.assertTrue(reviewHomePage.ratingHighlighted(starRating));
		writeReviewPage = reviewHomePage.mouseHoverOnRatingstarsAndClick(starRating);
		writeReviewPage.selectPolicyType(policyDropdown);
		writeReviewPage.enterTextReview(reviewContent);
		writeReviewPage.selectRatingstarsAndClick(starRating);
		writeReviewPage.submitReview();

		/* Was unable to complete the end to end flow. So was unable to assert */

	}
}
