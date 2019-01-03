package com.practice.utils;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.AuthenticationSpecification;
import io.restassured.specification.MultiPartSpecification;
import io.restassured.specification.ProxySpecification;
import io.restassured.specification.RedirectSpecification;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class HttpRestUtils {

	private static final String baseURI = Utility.getProperty("baseURI");
	private static final String basePath = Utility.getProperty("basePath");
	private static Response response;
	private static final String username = Utility.getProperty("AUTH_USERNAME");
	private static final String password = Utility.getProperty("AUTH_PASSWORD");
	public static Response getResponseContent() {
		return response;
	}
	
	//Start of get requests reusable methods
	public static Response fetchGetResponse() {
		try{
			Response response = RestAssured.given().when().get();
			HttpRestUtils.response = response;
			return response;
		}
		catch(Exception e){
			return null;
		}
	}
	
	public static Response fetchGetResponse(String path) {
		try{
			Response response = RestAssured.given().when().get(path);
			HttpRestUtils.response = response;
			return response;
		}
		catch(Exception e){
			return null;
		}
	}

	public static Response fetchGetResponse(Map<String, String> parameter, String path) {
		try{
			parameter.entrySet().stream().forEach(o -> RestAssured.given().param(o.getKey(), o.getValue()));
			Response response = RestAssured.when().get(path);
			HttpRestUtils.response = response;
			return response;
		}
		catch(Exception e){
			return null;
		}
	}

	public static ResponseBody<?> fetchGetResponseBody(String path) {
		try{
			return RestAssured.given().when().get(path).getBody();
		}
		catch(Exception e){
			return null;
		}
	}
	
	public static ResponseBody<?> fetchGetResponseBody(Map<String, String> params, String path) {
		try{
			RequestSpecification requestSpecification = RestAssured.given((RequestSpecification) params);
			ResponseBody<?> response = requestSpecification.when().get(path).getBody();
			return response;
		}
		catch(Exception e){
			return null;
		}
	}
	
	public static <T> Set<String> getBodyJsonList(String path) {
		return getKeysFromJson(fetchGetResponseBody(path).asString());
	}
	
	public static Set<String> getBodyJsonList(HashMap<String, String> params, String path) {
		return getKeysFromJson(fetchGetResponseBody(params, path).asString());
	}

	public static Set<String> getKeysFromJson(String jsonString) {
		JSONObject jsonObject = new JSONObject(jsonString);
		return jsonObject.keySet();
	}
	
	public static String getJsonKeyValue(ResponseBody<?> body, String key) {
		JSONObject jsonObject = new JSONObject(body.asString());
		return jsonObject.getString(key);
	}
	
	public static int getResponseStatusCode() {
		return response.getStatusCode();
	}
	
	public static String getResponseStatusLine() {
		return response.getStatusLine();
	}
	
	public static Response getStoredResponse() {
		return response;
	}
	
	
	
	
	//Start of post requests reusable methods
	public static <T> Response getPostResponse(T body, T contentType, String path) {
		Response response = RestAssured.given().body(body).contentType((ContentType) contentType).when().post(path);
		HttpRestUtils.response = response;
		return response;
	}

	public static <T> Response getPostResponse(HashMap<String, String> parameter, T body, String path) {
		parameter.entrySet().stream().forEach(o -> RestAssured.given().body(body).param(o.getKey(), o.getValue()));
		Response response = RestAssured.when().get(path);
		HttpRestUtils.response = response;
		return response;
	}
	
	//Start of delete requests reusable methods
	public static Response getDeleteResponse(String path) {
		Response response = RestAssured.given().when().delete(path);
		HttpRestUtils.response = response;
		return response;
	}
	
	public static ResponseBody getDeleteResponseBody(String path) {
		Response response = RestAssured.given().when().delete(path);
		HttpRestUtils.response = response;
		return response.body();
	} 
	
	public static Response getDeleteResponse(HashMap<String, String> parameter, String path) {
		parameter.entrySet().stream().forEach(o -> RestAssured.given().param(o.getKey(), o.getValue()));
		Response response = RestAssured.when().delete(path);
		HttpRestUtils.response = response;
		return response;
	}

	public static ResponseBody getDeleteResponseBody(HashMap<String, String> parameter, String path) {
		parameter.entrySet().stream().forEach(o -> RestAssured.given().param(o.getKey(), o.getValue()));
		Response response = RestAssured.when().delete(path);
		HttpRestUtils.response = response;
		return response.body();
	}

	public static Response postRequest(String path) {
		if(username.isEmpty() && password.isEmpty()) {
			Response reponse = RestAssured.given().when().get(path);
			HttpRestUtils.response = reponse;
			return HttpRestUtils.response;
		}
		else{
			Response reponse = RestAssured.given().auth().basic("", "").when().get(path);
			HttpRestUtils.response = reponse;
			return HttpRestUtils.response;
		}
	}
	
	public static Response postRequest(Map<String, String> param, String path) {
		if(username.isEmpty() && password.isEmpty()) {
			param.entrySet().stream().forEach(o -> RestAssured.given().param(o.getKey(), o.getValue()));
			Response reponse = RestAssured.when().get(path);
			HttpRestUtils.response = reponse;
			return HttpRestUtils.response;
		}
		else{
			param.entrySet().stream().forEach(o -> RestAssured.given().param(o.getKey(), o.getValue()));
			Response reponse = RestAssured.when().get(path);
			HttpRestUtils.response = reponse;
			return HttpRestUtils.response;
		}
	}
	

}
