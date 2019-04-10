package com.project.rest.webservice.Project.message;

import javax.validation.constraints.NotNull;

public class OrderForm {
	
	@NotNull
	private Long userID;
	
	public void setUserID(Long userID) {
		this.userID=userID;
	}
	public Long getUserID() {
		return this.userID;
	}
}
