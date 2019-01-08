package com.practice.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class SalesforceLoginTest extends BaseAbstractTest {

	@Test
	public void loginSalesforce() {
		getInstanceDriver().get("https://login.salesforce.com");
		getInstanceDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getInstanceDriver().findElement(By.name("username")).sendKeys("oceadmin@oce-uiauto.com");
		getInstanceDriver().findElement(By.id("password")).sendKeys("crm1OCE1");
		getInstanceDriver().findElement(By.id("Login")).click();
		waitUntilSpinnersDisappeared();
		waitUntilRequestsHaveFinished();
		getInstanceDriver().findElement(By.linkText("Accounts")).click();
		waitUntilSpinnersDisappeared();
		//waitUntilRequestsHaveFinished();
		getInstanceDriver().close();
	}
}
