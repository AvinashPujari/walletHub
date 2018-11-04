package com.automation.framework.wallethubpages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.framework.base.Base;
import com.automation.framework.utilities.AppUtility;

/*
 * Contain repo for wallet hub Review Home Page 
 * 
 * 
 * */
public class ReviewHomePage extends Base {

	public ReviewHomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "footer_cta")
	WebElement footerAd;

	@FindBy(xpath = "//span[@class='cta_arrow down']")
	WebElement footerAdClose;

	/*
	 * Got revised
	 * 
	 * @FindBy(xpath="//div/em[text()='']") WebElement labelThanksForRating;
	 */
	@FindBy(xpath = "//div/em[text()='Submit Your Rating']")
	WebElement labelThanksForRating;

	@FindBy(xpath = "//div[@class='wh-rating-choices-holder']")
	WebElement tooltipYourRating;

	@FindBy(xpath = "//div[@class='wh-rating-choices-holder']/a")
	List<WebElement> listOfRatingStars;

	public void closeFooterAd() {
		AppUtility.waitForElementtoBeClickable(footerAdClose);
		footerAdClose.click();
	}

	public void mouseHoverOnRatingLabel() {
		AppUtility.waitForElementtoBeClickable(labelThanksForRating);
		AppUtility.mouseHover(labelThanksForRating);
	}

	public WriteReviewPage mouseHoverOnRatingstarsAndClick(String ratingCount) {
		int count = (int) Math.round((Double.valueOf(ratingCount)));
		AppUtility.waitForElementtoBeClickable(listOfRatingStars.get(count - 1));
		AppUtility.mouseHover(listOfRatingStars.get(0), listOfRatingStars.get(count - 1));
		listOfRatingStars.get(count - 1).click();
		return new WriteReviewPage();
	}

	public boolean ratingHighlighted(String ratingCount) {

		int count = (int) Math.round((Double.valueOf(ratingCount)));
		boolean flag = false;
		AppUtility.mouseHover(listOfRatingStars.get(0), listOfRatingStars.get(count - 1));
		if ((listOfRatingStars.get(0).getAttribute("class")).equalsIgnoreCase("hover")
				&& (listOfRatingStars.get(0).getAttribute("class")).equalsIgnoreCase("hover")) {
			flag = true;
		}
		return flag;
	}

}
