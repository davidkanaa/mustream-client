package com.mustream.app.models.entities;

import com.mustream.app.models.entities.User;

public class CurrentUser extends User {
	
	private static CurrentUser instance_ = null;
	private String accessToken;
	
	public CurrentUser(){
		//TODO change for final version. admin is for development
		setAccessToken("accessToken");
	}
	
	
	public static CurrentUser getInstance(){
		if (instance_ == null){
	          instance_ = new CurrentUser();
	      }
	      return instance_;
	}


	public String getAccessToken() {
		return accessToken;
	}


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
