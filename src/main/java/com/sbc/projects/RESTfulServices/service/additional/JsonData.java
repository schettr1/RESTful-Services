package com.sbc.projects.RESTfulServices.service.additional;

public class JsonData {

	private String message;

	public JsonData(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "JsonData [message=" + message + "]";
	}



	

	
	
}
