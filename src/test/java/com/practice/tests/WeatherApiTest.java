package com.practice.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.practice.utils.Assertions;
import com.practice.utils.HttpConstants;
import com.practice.utils.HttpRestUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class WeatherApiTest {

	@BeforeClass
	public void before() {
		RestAssured.baseURI = "http://api.openweathermap.org";
		RestAssured.basePath = "/data/2.5";
	}
	
	@Test()
	public void test() {
		Response response = RestAssured.given().queryParam("zip", "94040,US")
		.queryParam("appid", "bbe5c03fdb35096bf628fc89b5684b30").when().get("/weather");
		Assertions.shouldBeEqual(response.getStatusCode(), HttpConstants.RESPONSE_CODE_200);
	}
}
