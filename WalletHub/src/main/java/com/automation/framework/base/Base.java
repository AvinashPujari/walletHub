package com.automation.framework.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automation.framework.facebookpages.FacebookHomePage;
import com.automation.framework.facebookpages.FacebookLoginPage;

public class Base {

	public static Properties configProp;
	public static WebDriver driver;
	public static String baseURL = System.getProperty("user.dir");

	public Base() {

		try {
			configProp = new Properties();
			FileInputStream fileInput = new FileInputStream(
					baseURL + "\\src\\main\\java\\com\\automation\\framework\\config\\Config.properties");
			configProp.load(fileInput);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void setup() {

		setBrowser();
		setDimension();
		clearBrowsercache();
		setTimeOut();
	}

	public void getFacebookURL() {
		driver.get(configProp.getProperty("FacebookUrl"));

	}

	public void getWalletHubURL() {
		driver.get(configProp.getProperty("WalletHubUrl"));

	}

	private void setBrowser() {
		String browserName = configProp.getProperty("Browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", baseURL + "\\resource\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver();
		} else {
			System.out.println("Browser Out Of Scope/ reverify the browser");
		}

	}

	private void setTimeOut() {
		long IMPLICIT_WAIT_TIMEOUT = Long.parseLong(configProp.getProperty("ImplicitWait"));
		long EXPLICIT_WAIT_TIMEOUT = Long.parseLong(configProp.getProperty("ExplicitWait"));
		long PAGE_LOAD_TIMEOUT = Long.parseLong(configProp.getProperty("PageLoadTimeOut"));

		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);

	}

	private void setDimension() {
		int WIDTH = Integer.parseInt(configProp.getProperty("DimensionWidth"));
		int HEIGHT = Integer.parseInt(configProp.getProperty("DimensionHeight"));
		Dimension screenResolution = new Dimension(WIDTH, HEIGHT);
		driver.manage().window().setSize(screenResolution);
	}

	private void clearBrowsercache() {
		driver.manage().deleteAllCookies();
	}
}
