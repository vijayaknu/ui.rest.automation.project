package com.practice.utils;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.restassured.response.ResponseBody;

public class Assertions {

	public static <T> void shouldBeEqual(T actual, T expected) {
		Assert.assertEquals(actual, expected);
	} 

	public static void shouldBeTrue(boolean condition) {
		Assert.assertEquals(condition, true);
	}

	public static void shouldBeFalse(boolean condition) {
		Assert.assertEquals(condition, false);
	}
	
	public static <T> void shouldNotEqual(T actual, T expected) {
		Assert.assertFalse(actual.equals(expected) ? true : false);
	}

	public static void shouldContains(ResponseBody<?> body, String expected) {
		Assert.assertTrue(body.asString().contains(expected) ? true : false);
	}
}
