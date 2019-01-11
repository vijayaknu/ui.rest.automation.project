package com.practice.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;

public abstract class AbstractDriver {

	private static WebDriver driver;
	private static NgWebDriver angularJsDriver;
	private static JavascriptExecutor jse;

	public AbstractDriver() {
		//startNewInstance();
	}

	public static void startNewInstance() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		jse = (JavascriptExecutor) driver;
		angularJsDriver = new NgWebDriver(jse);
		// angularJsDriver.waitForAngularRequestsToFinish();
	}

	public static WebDriver getInstanceDriver() {
		return getInstanceDriverObject();
	}

	public static NgWebDriver getAngularDriver() {
		return getInstanceAngularObject();
	}

	public static JavascriptExecutor getJavaScriptExecutor() {
		return (JavascriptExecutor) getInstanceDriver();
	}

	private static WebDriver getInstanceDriverObject() {
		return driver;
	}

	private static NgWebDriver getInstanceAngularObject() {
		return angularJsDriver;
	}

	public static void waitUntilRequestsHaveFinished() {
		waitForPageLoad();
		//jse.executeAsyncScript(
		//		"var callback = arguments[arguments.length - 1]; var xhr = new XMLHttpRequest(); xhr.open('POST', '/Ajax_call', true); xhr.onreadystatechange = function() { if (xhr.readyState == 4) {callback(xhr.responseText);}}; xhr.send();");
		 angularJsDriver.waitForAngularRequestsToFinish();
	}

	public static void waitForPageLoad() {
		while (true) {
			try {
				if (getJavaScriptExecutor().executeScript("return document.readyState").equals("complete"))
					break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void waitUntilSpinnersDisappeared() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.invisibilityOfAllElements(
					getInstanceDriver().findElements(By.xpath("//*[contains(@class,'slds-hide')]"))));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
