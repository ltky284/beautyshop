package com.springboot.beautyshop.util;

public class APIMessage {
	private String errorMessage;
	
	public APIMessage(String errMess) {
		errorMessage=errMess;
	};

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
