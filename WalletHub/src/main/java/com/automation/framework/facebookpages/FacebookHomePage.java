package com.automation.framework.facebookpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.framework.base.Base;
import com.automation.framework.utilities.AppUtility;

/*
 * Object repo for facbook Home page
 * */
public class FacebookHomePage extends Base {

	public FacebookHomePage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[ @data-click='home_icon']")
	WebElement linkHome;

	public boolean homeButtonPresent() {
		AppUtility.waitForElementtoBeClickable(linkHome);
		if (linkHome.isDisplayed())
			return true;
		return false;

	}
}