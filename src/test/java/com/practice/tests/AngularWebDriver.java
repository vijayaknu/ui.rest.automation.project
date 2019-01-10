package com.practice.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularOptions;
import com.paulhammant.ngwebdriver.ByAngularRepeater;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.practice.utils.ByCustomAngular;

public class AngularWebDriver {

	static WebDriver driver;
	static NgWebDriver ngdriver;

	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		ngdriver = new NgWebDriver(jse);//.withRootSelector("html.ng-scope");
		ByCustomAngular by = new ByCustomAngular(jse);
		//Sample AngularJs Webpage
/*		driver.get("https://hello-angularjs.appspot.com/sorttablecolumn");
		ngdriver = new NgWebDriver((JavascriptExecutor) driver);//.withRootSelector("html.ng-scope");
		//ByAngular.Factory byAngular = ngdriver.makeByAngularFactory();
		driver.findElement(ByAngular.model("name")).sendKeys("Test Company");
		driver.findElement(ByAngular.model("employees")).sendKeys("1000");
		driver.findElement(ByAngular.model("headoffice")).sendKeys("Mysore");
		driver.findElement(ByAngular.buttonText("Submit")).click();
		System.out.println(ngdriver.getLocationAbsUrl());
		Thread.sleep(2000);
		String txt = driver.findElement(ByAngular.repeater("company in companies").row(4).column("name")).getText();
		System.out.println(txt + " Added.");

		System.out.println(driver.findElements(ByAngular.repeater("company in companies")).size());
		driver.findElements(ByAngular.repeater("company in companies")).stream().forEach(o -> {System.out.println(o.getText());});
		if(txt.equalsIgnoreCase("Test Company")){
			System.out.println("New Company Added. Now remove it");
			driver.findElement(ByAngular.repeater("company in companies").row(4)).findElement(ByAngular.buttonText("Remove")).click();
		}
		System.out.println(driver.findElements(ByAngular.repeater("company in companies")).size());
		driver.findElements(ByAngular.repeater("company in companies")).stream().forEach(o -> {System.out.println(o.getText());});

		Thread.sleep(3000);
*/		
		
		driver.get("http://www.way2automation.com/angularjs-protractor/calc/");
		driver.findElement(ByAngular.model("first")).sendKeys("49");
		driver.findElements(ByAngular.options("value for (key, value) in operators")).stream().filter(o -> o.getAttribute("value").equals("ADDITION")).findFirst().get().click();;
		driver.findElement(ByAngular.model("second")).sendKeys("51");
		//driver.findElement(ByAngular.buttonText("Go!")).click();
		driver.findElement(By.xpath("//button[@ng-click='doAddition()']")).click();
		ngdriver.waitForAngularRequestsToFinish();	
		String print = driver.findElements(By.xpath("//h2")).stream().filter(o -> o.getText().equals("100")).findFirst().get().getText();
		System.out.println(print);
		
		driver.get("http://www.way2automation.com/angularjs-protractor/checkboxes/");
		
		driver.findElements(ByAngular.repeater("division in data.divisions")).forEach(o -> {System.out.println(o.getText());});
		System.out.println("-----------------------------------------------");
		driver.findElement(ByAngular.repeater("division in data.divisions")).findElements(ByAngular.repeater("cat in division.categories")).forEach(o -> {System.out.println(o.getText());});
		/*		cat in division.categories
		prod in cat.products
*/		
		
		
		driver.get("http://www.way2automation.com/angularjs-protractor/multiform/#/form/profile");
		ngdriver.waitForAngularRequestsToFinish();	
		driver.findElement(ByAngular.model("formData.name")).sendKeys("Murthy");
		driver.findElement(ByAngular.model("formData.email")).sendKeys("Murthy@abcmail.com");
		driver.findElement(By.partialLinkText("Next Section")).click();
		ngdriver.waitForAngularRequestsToFinish();	
		driver.findElements(By.xpath("//label[input[@ng-model='formData.type']]")).stream().forEach(o -> System.out.println(o.getAttribute("text")));
		driver.findElements(By.xpath("//label[input[@ng-model='formData.type']]")).stream().filter(o -> o.getText().contains("XBOX")).findFirst().get().click();
		driver.quit();

	}
}