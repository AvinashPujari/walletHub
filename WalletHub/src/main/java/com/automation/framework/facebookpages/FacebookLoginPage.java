package com.automation.framework.facebookpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.framework.base.Base;
import com.automation.framework.utilities.AppUtility;

/*
 * Object repo for facbook login page
 * */
public class FacebookLoginPage extends Base {

	public FacebookLoginPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[@id='email']")
	WebElement textBoxLoginEmailId;

	@FindBy(xpath = "//*[@id='pass']")
	WebElement textBoxLoginpassword;

	@FindBy(xpath = "//input[@data-testid='royal_login_button']")
	WebElement buttonLogin;

	public FacebookHomePage logIn(String username, String userPassword) {
		AppUtility.waitForElementtoBeClickable(buttonLogin);

		textBoxLoginEmailId.sendKeys(username);

		textBoxLoginpassword.sendKeys(userPassword);

		buttonLogin.click();

		return new FacebookHomePage();
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();

	}
}
