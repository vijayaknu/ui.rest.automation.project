package com.practice.datamodels;

public class PetModel {

	private static String status = "";
	private int id;
	private String petName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	
	private String categoryText =   "\"category\": {"+
	    								"\"id\": 0,"+
	    							"\"name\": \"string\""+
	  								"},";
	
	private String photoTagsStatus =   "\"photoUrls\": ["+
	                                              "\"string\""+
	                                              "],"+
	                                    "\"tags\": ["+
	                                         "{"+
	                                              "\"id\": 0,"+
	                                              "\"name\": \"string\""+
	                                              "}"+
	                                              "],"+
	                                              "\"status\": \""+status+"\""+
											"}";							
	
	
	public String getPetJson(int id, String petName) {
		status = "available";
		setId(id);
		setPetName(petName);
		System.out.println("this.photoTagsStatus="+this.photoTagsStatus);
		return 	"{"+
				"\"id\":"+getId()+","+
				categoryText+
				"\"name\":\""+getPetName()+"\""+","+
				this.photoTagsStatus;
	}
	
	public String getPetJson(int id, String petName, String status) {
		PetModel.status = status;
		setId(id);
		setPetName(petName);
		return 	"{"+
				"\"id\":"+getId()+","+
				categoryText+
				"\"name\":\""+getPetName()+"\""+","+
				photoTagsStatus;
	}

}
