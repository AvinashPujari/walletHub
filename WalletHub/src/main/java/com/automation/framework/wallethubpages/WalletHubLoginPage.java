package com.automation.framework.wallethubpages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import com.automation.framework.base.Base;
import com.automation.framework.utilities.AppUtility;

/*
 * Contain repo for wallet hub login Page 
 * 
 * 
 * */
public class WalletHubLoginPage extends Base {

	public WalletHubLoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li/a[text()='Login']")
	WebElement tabLogin;

	@FindBy(xpath = "//div/input[@ng-model='fields.email']")
	WebElement textLoginEmailid;

	@FindBy(xpath = "//div/input[@ng-model='fields.password1'  and @type='password']")
	WebElement textLoginPassword;

	@FindBy(xpath = "//div/button//span[text()='Login']")
	WebElement buttonLogin;

	public ReviewHomePage login(String emailId, String password) {
		AppUtility.waitForElementtoBeClickable(tabLogin);
		tabLogin.click();
		AppUtility.waitForElementtoBeClickable(textLoginEmailid);
		textLoginEmailid.sendKeys(emailId);
		textLoginPassword.sendKeys(password);
		buttonLogin.click();
		getProfileUrl();
		return new ReviewHomePage();

	}

	private void getProfileUrl() {
		driver.get(configProp.getProperty("ProfileUrl"));
	}
}
