package com.sbc.projects.RESTfulServices.exceptions;

import java.util.Date;

public class CustomResponseMessage {

	// Items to display in Http Response 
	
	private Date timestamp;
	private String messege;
	private String error;
	
	public CustomResponseMessage() {

	}

	public CustomResponseMessage(Date timestamp, String messege, String error) {
		this.timestamp = timestamp;
		this.messege = messege;
		this.error = error;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "CustomResponseException [timestamp=" + timestamp + ", messege=" + messege + ", error=" + error + "] \n";
	}
	
	
	
	
	
	
	
	
	
}
