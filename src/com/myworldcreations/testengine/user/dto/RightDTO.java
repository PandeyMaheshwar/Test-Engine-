package com.myworldcreations.testengine.user.dto;

public class RightDTO {
	private String name;
	private String screenName;
	public RightDTO(String name, String sreenName){
		this.name = name;
		this.screenName = screenName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	
	

}
