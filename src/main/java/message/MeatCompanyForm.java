package com.project.rest.webservice.Project.message;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MeatCompanyForm {
	@NotBlank
	@Size(min=3, max=60)
	private String name;
	
	@NotBlank
	@Size(max=60)
	private String email;
	
	private Set<String>product;
	
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
	
	public Set<String> getProducts(){
		return product;
	}
	public void setProducts(Set<String> product) {
		this.product=product;
	}

}
