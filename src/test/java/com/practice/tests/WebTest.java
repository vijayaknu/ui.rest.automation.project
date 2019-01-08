package com.practice.tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class WebTest extends BaseAbstractTest{

	//@Test
	public void loginTest() {
		getInstanceDriver().get("https://demo.actitime.com");
		getInstanceDriver().manage().window().maximize();
		getInstanceDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getInstanceDriver().close();
	}
}
