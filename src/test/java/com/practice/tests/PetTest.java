package com.practice.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.xml.XmlTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParser;
import com.practice.datamodels.PetModel;
import com.practice.utils.Assertions;
import com.practice.utils.HttpConstants;
import com.practice.utils.HttpRestUtils;
import com.practice.utils.PathConstants;
import com.practice.utils.Utility;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import jdk.nashorn.internal.parser.JSONParser;

public class PetTest extends BaseAbstractTest{
	private String petId;// = "55555";
	private String petName; // = "Grammy Bammy";
	SoftAssert soft = new SoftAssert();
	
	@Factory(dataProvider = "set-of-test-data")
	public PetTest(String id, String name) {
		this.petId = id;
		this.petName = name;
	}
	
	@DataProvider(name = "set-of-test-data")
	public static Object[][] credentials() {
		return new Object[][] { {"10123", "Goomy"}, {"102645", "Broomy"}, {"6548945","Goomy"}, {"987453","Broomy"}
							, {"547695", "Batme"}, {"254357", "Leemy"}};
	}

	@BeforeTest
    public void testSetUp(XmlTest test) {
        test.setGroupByInstances(true);
    }
	
	@Test()
	public void createPet() {
		System.out.println("1 - create pet");
		PetModel petModel = new PetModel();
		HttpRestUtils.getPostResponse(petModel.getPetJson(Integer.parseInt(petId), petName), ContentType.JSON, PathConstants.createPetPath());		
		Assertions.shouldBeEqual(HttpRestUtils.getResponseStatusCode(), HttpConstants.RESPONSE_CODE_200);
	}
	
	@Test(dependsOnMethods = "createPet")
	public void getPetInformation() {
		System.out.println("2 - pet infor");
		String name = HttpRestUtils.getJsonKeyValue(HttpRestUtils.fetchGetResponseBody(PathConstants.findPetPath(petId)), "name");
		soft.assertEquals(HttpRestUtils.getResponseStatusCode(), HttpConstants.RESPONSE_CODE_200);
		soft.assertEquals(name, petName);
		soft.assertAll();
	}
	
	@Test(dependsOnMethods = "getPetInformation")
	public void updatePetName() {
		System.out.println("3 - update pet infor");
		PetModel petModel = new PetModel();
		HttpRestUtils.getPostResponse(petModel.getPetJson(Integer.parseInt(petId), petName+"_"+petName), ContentType.JSON, PathConstants.updatePetPath());
		Assertions.shouldBeEqual(HttpRestUtils.getResponseStatusCode(), HttpConstants.RESPONSE_CODE_200);
	}
	
	@Test(dependsOnMethods = "updatePetName")
	public void getUpdatedPetInformation() {
		System.out.println("4 - modified pet infor");
		String name = HttpRestUtils.getJsonKeyValue(HttpRestUtils.fetchGetResponseBody(PathConstants.findPetPath(petId)), "name");
		soft.assertEquals(HttpRestUtils.getResponseStatusCode(), HttpConstants.RESPONSE_CODE_200);
		soft.assertEquals(name, petName+"_"+petName);
		soft.assertAll();
	}
	
	@Test(dependsOnMethods = "getUpdatedPetInformation")
	public void deletePet() {
		System.out.println("5 - delete pet");
		HashMap<String, String> map = new HashMap<>();
		map.put(Utility.getProperty(PathConstants.API_KEY), Utility.getProperty(PathConstants.API_KEY_VALUE));
		HttpRestUtils.getDeleteResponse(map, PathConstants.deletePetPath(petId));
		soft.assertEquals(HttpRestUtils.getResponseStatusCode(), HttpConstants.RESPONSE_CODE_200);
		soft.assertAll();
	}
}