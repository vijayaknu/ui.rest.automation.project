package com.practice.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.practice.utils.Utility;
import io.restassured.RestAssured;

public abstract class BaseAbstractTest {
	
	WebDriver driver;
	
	@BeforeSuite
	public void setup() {
		RestAssured.baseURI = Utility.getProperty("baseURI");
		RestAssured.basePath = Utility.getProperty("basePath");
		//System.out.println("At Before Suite");
/*		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
*/	}
	
	@AfterSuite
	public void sendEmail() {
		//System.out.println("At After Suite");
		//System.out.println("#####################################################################");
		//driver.quit();
		//Utility.sendEmail();
	}
	
	@BeforeTest
	public void beforeTest() {
		//System.out.println("At Before test");
	}
	
	@AfterTest
	public void afterTest() {
		//System.out.println("At After test");
	}
	
	@BeforeClass
	public void beforeClass() {
		//System.out.println("At before class");
	}
	
	@AfterClass
	public void afterClass() {
		//System.out.println("At after class");
	}
	
	@BeforeGroups
	public void beforeGroup(){
		//System.out.println("At before group");
	}
	
	@AfterGroups
	public void afterGroup(){
		//System.out.println("At after group");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		//System.out.println("At before method");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		//System.out.println("At After method");
	}
	
}
