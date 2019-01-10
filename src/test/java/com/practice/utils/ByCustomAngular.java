package com.practice.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ByCustomAngular extends By{

	private String ngClick;
	private static JavascriptExecutor jse;
	public ByCustomAngular(JavascriptExecutor jse, String ngClick) {
		ByCustomAngular.jse = jse;
		this.ngClick = ngClick;
	}

	public ByCustomAngular(JavascriptExecutor jse) {
		this.jse = jse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WebElement> findElements(SearchContext context) {
		// TODO Auto-generated method stub
		if (context instanceof WebDriver)
			context = null;

		Object o = jse.executeScript("var using = arguments[0] || document;\r\n"+
				"var customlocators = function() {\n"+
				"by.addLocator('ngClick', function(toState,parentelement) {\n"+
				"	 var using = parentelement || document ;\n"+
				"	 var prefixes = ['ng-click'];\n"+
				"      for (var p = 0; p < prefixes.length; ++p) {\n"+
				"         var selector = '*[' + prefixes[p] + '=\"' + toState + '\"]';\n"+
				"          var inputs = using.querySelectorAll(selector);\n"+
				"          if (inputs.length) {\n"+
				"              return inputs;\n"+
				"          }\n"+
				"      }\n"+		

			"});\n"+
			"}\n"+

			"module.exports = new customlocators();\n", context);
		if (o ==null)
		{
			throw new NoSuchElementException("No such element");
		}
		return (List<WebElement>)o;
	}

	@Override
	public WebElement findElement(SearchContext context)
	{
		if (context instanceof WebDriver)
			context = null;

		Object o = jse.executeScript("var using = arguments[0] || document;\r\n"+
				"var customlocators = function() {\n"+
				"by.addLocator('ngClick', function(toState,parentelement) {\n"+
				"	 var using = parentelement || document ;\n"+
				"	 var prefixes = ['ng-click'];\n"+
				"      for (var p = 0; p < prefixes.length; ++p) {\n"+
				"         var selector = '*[' + prefixes[p] + '=\"' + toState + '\"]';\n"+
				"          var inputs = using.querySelectorAll(selector);\n"+
				"          if (inputs.length) {\n"+
				"              return inputs;\n"+
				"          }\n"+
				"      }\n"+		

			"});\n"+
			"}\n", context);
		if (o ==null)
		{
			throw new NoSuchElementException("No such element");
		}
		return (WebElement)o;
	}

	@Override
	public String toString() {
		return "By.ngClick: " + ngClick;
	}


	public static ByCustomAngular ngClick(String clickString) {
		return new ByCustomAngular(jse, clickString);
	}
}
/*	public static WebElement ngClick(String parentElment) {
		Object o = ((JavascriptExecutor)AbstractDriver.getInstanceDriver()).executeScript(  
			"var customlocators = function() {\n"+
			"by.addLocator('ngClick', function(toState,parentelement) {\n"+
			"	 var using = parentelement || document ;\n"+
			"	 var prefixes = ['ng-click'];\n"+
			"      for (var p = 0; p < prefixes.length; ++p) {\n"+
			"         var selector = '*[' + prefixes[p] + '=\"' + toState + '\"]';\n"+
			"          var inputs = using.querySelectorAll(selector);\n"+
			"          if (inputs.length) {\n"+
			"              return inputs;\n"+
			"          }\n"+
			"      }\n"+		

		"});\n"+
		"}\n"+

		"module.exports = new customlocators();\n");
		return (WebElement) o;

	}*/

