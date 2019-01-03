package com.practice.tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class WebTest extends BaseAbstractTest{

	//@Test
	public void loginTest() {
		driver.get("https://demo.actitime.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.close();
	}
}
