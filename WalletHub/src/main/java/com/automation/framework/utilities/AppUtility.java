package com.automation.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.framework.base.Base;

/*
 * General Utility
 * 
 * 
 * 
 * */

public class AppUtility extends Base {
	static WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(configProp.getProperty("ExplicitWait")));

	public static String encodePassword(String password) {
		return new String(Base64.encodeBase64String(password.getBytes()));

	}

	public static String decodePassword(String password) {
		return new String(Base64.decodeBase64(password.getBytes()));

	}

	public static Object[][] getsExceldata(String sheetName) {

		FileInputStream file = null;
		Workbook book = null;
		Sheet sheet;

		try {

			file = new FileInputStream(Base.baseURL + "\\resource\\TestData.xlsx");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);

		String[][] testData = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {

			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				testData[i][k] = sheet.getRow(i + 1).getCell(k).toString();

			}
		}

		return testData;

	}

	public static void mouseHover(WebElement... destination) {
		Actions action = new Actions(driver);
		if (destination.length == 1) {
			action.moveToElement(destination[0]).build().perform();
		}

		else {
			action.moveToElement(destination[0]).moveToElement(destination[1]).build().perform();
		}
	}

	public static WebElement getElementFromList(List<WebElement> elementList, String elementname) {
		WebElement element = null;
		for (WebElement elementTemp : elementList) {
			if (elementTemp.getText().equalsIgnoreCase(elementname)) {
				element = elementTemp;
			}
		}
		return element;
	}

	public static void waitForElementtoBeClickable(WebElement element) {
		try {

			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			System.out.println("Element not clickable");
		}
	}
}
