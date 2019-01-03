package com.practice.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.practice.datamodels.PetModel;
import com.practice.utils.Assertions;
import com.practice.utils.HttpConstants;
import com.practice.utils.HttpRestUtils;
import com.practice.utils.PathConstants;

import io.restassured.http.ContentType;

public class FindPetTest extends BaseAbstractTest {
	private String petId;
	private String petName; 
	private String petStatus; 
	SoftAssert soft = new SoftAssert();
	
	@Factory(dataProvider = "set-of-test-data")
	public FindPetTest(String id, String name, String status) {
		this.petId = id;
		this.petName = name;
		this.petStatus = status;
		System.out.println("petId="+this.petId+" petName="+this.petName+" petStatus="+this.petStatus);
	}
	
	@DataProvider(name = "set-of-test-data")
	public static Object[][] credentials() {
		return new Object[][] { {"10123", "Goomy", "available"}, {"102645", "Broomy", "pending"}, 
								{"6548945","Goomy", "sold"}, {"987453","Broomy", "available"},
								{"547695", "Batme", "pending"}, {"254357", "Leemy", "sold"}};
	}
	
	@Test()
	public void getAvailablePets() {
		Map<String, String> map = new HashMap<>();
		map.put(petId, petName);
		PetModel petModel = new PetModel();
		HttpRestUtils.getPostResponse(petModel.getPetJson(Integer.parseInt(petId), petName, petStatus), ContentType.JSON, PathConstants.createPetPath());
		HttpRestUtils.fetchGetResponse(map, PathConstants.findByStatusPath());
		Assertions.shouldBeEqual(HttpRestUtils.getResponseStatusCode(), HttpConstants.RESPONSE_CODE_200);
	}
}
