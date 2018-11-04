package com.automation.framework.wallethubpages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.framework.base.Base;
import com.automation.framework.utilities.AppUtility;

/*
 * Contain repo for wallet hub write review page 
 * 
 * 
 * */
public class WriteReviewPage extends Base {

	public WriteReviewPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='dropdown-title']/span[text()='Please select your policy']")
	WebElement dropdownSelectPolicy;

	@FindBy(xpath = "//div[@class='dropdown-list-new opened']/ul/li")
	List<WebElement> listSelectPolicy;

	@FindBy(id = "review-content")
	WebElement textFieldWriteReview;

	@FindBy(xpath = "//div/input[@type='submit']")
	WebElement buttonReviewSubmit;

	@FindBy(xpath = "//div/span[@id='overallRating']/a")
	List<WebElement> reviewStars;

	public void selectPolicyType(String policyType) {
		dropdownSelectPolicy.click();
		AppUtility.getElementFromList(listSelectPolicy, policyType).click();
	}

	public void enterTextReview(String reviewText) {
		textFieldWriteReview.sendKeys(reviewText);
	}

	public void submitReview() {
		AppUtility.waitForElementtoBeClickable(buttonReviewSubmit);
		buttonReviewSubmit.click();
	}

	public void selectRatingstarsAndClick(String ratingCount) {
		int count = (int) Math.round((Double.valueOf(ratingCount)));
		AppUtility.mouseHover(reviewStars.get(0), reviewStars.get(count - 1));
		reviewStars.get(count - 1).click();

	}
}
