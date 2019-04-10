package com.project.rest.webservice.Project.message;

import java.util.Set;

import javax.validation.constraints.*;



public class SignUpForm {


	@Size(min=3, max=60)
	private String name;
	
	@Size(min=3, max=60)
	private String username;

	@Size(max=60)
	private String email;
	
	private Set<String>role;
	

	@Size(min=3, max=30)
	private String password;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Set<String> getRoles(){
		return role;
	}
	public void setRoles(Set<String> role) {
		this.role=role;
	}
}
