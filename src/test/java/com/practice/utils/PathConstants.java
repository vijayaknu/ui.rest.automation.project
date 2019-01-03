package com.practice.utils;

public abstract class PathConstants {
	
	public static final String API_KEY = "API_KEY";
	public static final String API_KEY_VALUE = "API_KEY_VALUE";
	public static final String STORE = "/store";
	public static final String PET = "/pet";
	public static final String USER = "/user";
	
	public static final String createPetPath() {
		return PET;
	}
	
	public static final String updatePetPath() {
		return PET;
	} 
	
	public static final String findByStatusPath() {
		return PET+"/findByStatus";
	}

	public static final String findPetPath(String petId) {
		return PET+"/"+petId;
	}
	
	public static final String updatePetPath(String petId) {
		return PET+"/"+petId;
	}
	
	public static final String deletePetPath(String petId) {
		return PET+"/"+petId;
	}
	
	public static final String uploadImagePath(String petId) {
		return PET+"/"+petId+"/uploadImage";
	}
	
	public static final String petInventoryPath() {
		return STORE+"/inventory";
	}

	public static final String petOrderPath() {
		return PET+"/order";
	}
	
	public static final String findPurchaseOrderPath(String orderId) {
		return PET+"/order/"+orderId;
	}
	
	public static final String deleteOrderPath(String orderId) {
		return PET+"/order/"+orderId;
	}
	
	public static final String createUserPath() {
		return USER;
	}
	
	public static final String createWithArrayPath() {
		return USER+"/createWithArray";
	}
	
	public static final String createWithListPath() {
		return USER+"/createWithList";
	}

	public static final String loginPath() {
		return USER+"/login";
	}
	
	public static final String logoutPath() {
		return USER+"/logout";
	}
	
	public static final String getUserPath(String username) {
		return USER+"/"+username;
	}
	
	public static final String updateUserPath(String username) {
		return USER+"/"+username;
	}

	public static final String deleteUserPath(String username) {
		return USER+"/"+username;
	}
}
