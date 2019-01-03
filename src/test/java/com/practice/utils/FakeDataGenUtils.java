package com.practice.utils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.javafaker.Faker;

public class FakeDataGenUtils {

	Faker faker;

	public FakeDataGenUtils() {
		faker = new Faker();
	}

	public Map<String, String> getPersonFakeData() {
		Object methodName = faker.name();
		return getMethodDetails(methodName);
	}

	public Map<String, String> getAddressFakeData() {
		Object methodName = faker.address();
		return getMethodDetails(methodName);
	}

	public Map<String, String> getBookFakeData() {
		Object methodName = faker.book();
		return getMethodDetails(methodName);
	}

	public Map<String, String> getAncientFakeData() {
		Object methodName = faker.ancient();
		return getMethodDetails(methodName);
	}

	public Map<String, String> getAppFakeData() {
		Object methodName = faker.app();
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getArtistFakeData() {
		Object methodName = faker.artist();
		return getMethodDetails(methodName);
	}

	public Map<String, String> getBeerFakeData() {
		Object methodName = faker.beer();
		return getMethodDetails(methodName);
	}

	public Map<String, String> getBoolFakeData() {
		Object methodName = faker.bool();
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getBusinessFakeData() {
		Object methodName = faker.business();
		return getMethodDetails(methodName);
	}

	public Map<String, String> getCatFakeData() {
		Object methodName = faker.cat();
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getChuckNorrisFakeData() {
		Object methodName = faker.chuckNorris();
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getCodeFakeData() {
		Object methodName = faker.code();
		return getMethodDetails(methodName);
	}

	public Map<String, String> getColorFakeData() {
		Object methodName = faker.color();
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getCommerceFakeData() {
		Object methodName = faker.commerce();
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getCompanyFakeData() {
		Object methodName = faker.company();
		return getMethodDetails(methodName);
	}

	public Map<String, String> getCryptoFakeData() {
		Object methodName = faker.crypto();
		return getMethodDetails(methodName);
	}

	public Map<String, String> getDateFakeData() {
		Object methodName = faker.date();
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getDemographicFakeData() {
		Object methodName = faker.demographic();
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getEducatorFakeData() {
		Object methodName = faker.educator();
		return getMethodDetails(methodName);
	}

	public Map<String, String> getFileFakeData() {
		Object methodName = faker.file();
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getFinanceFakeData() {
		Object methodName = faker.finance();
		return getMethodDetails(methodName);
	}

	public Map<String, String> getFoodFakeData() {
		Object methodName = faker.food();
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getHackerFakeData() {
		Object methodName = faker.hacker();
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getIdNumberFakeData() {
		Object methodName = faker.idNumber();
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getInternetFakeData() {
		Object methodName = faker.internet();
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getMusicFakeData() {
		Object methodName = faker.music();
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getNumberFakeData() {
		Object methodName = faker.number();
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getOptionsFakeData() {
		Object methodName = faker.options();
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getPhoneNumberFakeData() {
		Object methodName = faker.phoneNumber();
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getRandomString() {
		Object methodName = faker.random();
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getSpace() {
		Object methodName = faker.space();
		return getMethodDetails(methodName);
	}

	public Map<String, String> getStockFakeData() {
		Object methodName = faker.stock();
		return getMethodDetails(methodName);
	}

	public Map<String, String> getTeamFakeData() {
		Object methodName = faker.team();
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getUniversityFakeData() {
		Object methodName = faker.university();
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getFakeCharacter() {
		Object methodName = faker.lorem().character();
		return getMethodDetails(methodName.toString());
	}
	
	public Map<String, String> getFakeCharacters() {
		Object methodName = faker.lorem().characters();
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getFakeCharacters(int charLength) {
		Object methodName = faker.lorem().characters(charLength);
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getFakeCharacters(int charLength, boolean trueOrFalse) {
		Object methodName = faker.lorem().characters(charLength, trueOrFalse);
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getFixedString(int strLength) {
		Object methodName = faker.lorem().fixedString(strLength);
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getFakeParagraph() {
		Object methodName = faker.lorem().paragraph();
		return getMethodDetails(methodName);
	}

	public Map<String, String> getFakeParagraph(int wordCount) {
		Object methodName = faker.lorem().paragraph(wordCount);
		return getMethodDetails(methodName);
	}
	
	public Map<String, String> getFakeSentences(int sentenceCount) {
		Object methodName = faker.lorem().sentences(sentenceCount);
		return getMethodDetails(methodName);
	}

	public Map<String, String> getFakeWord() {
		Object methodName = faker.lorem().word();
		return getMethodDetails(methodName);
	}
	
	public List<String> getFakeWords() {
		//Object methodName = faker.lorem().words(num)words();
		return faker.lorem().words();
	}
	
	private static Map<String, String> getMethodDetails(Object methodName) {
		Map<String, String> map = new HashMap<>();
		Method[] methods = methodName.getClass().getDeclaredMethods();
		Arrays.asList(methods).stream().forEach(o -> {
			try { 
				map.put(o.getName().toString(), (String) o.invoke(methodName));
			}
			catch (IllegalArgumentException e) {
				System.out.println(o.getName().toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return map;
	}
}
