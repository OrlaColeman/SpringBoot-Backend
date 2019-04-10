package com.project.rest.webservice.Project.model.Meat;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "mcompany")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String CompanyName;
	
	@NotNull
	@Email
	private String CompanyEmail;
	
	public Company() {}
	
	public Company(String CompanyName, String CompanyEmail) {
		this.CompanyName=CompanyName;
		this.CompanyEmail=CompanyEmail;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String CompanyName) {
		this.CompanyName = CompanyName;
	}
	public String getCompanyEmail() {
		return CompanyEmail;
	}
	public void setCompanyEmail(String CompanyEmail) {
		this.CompanyEmail=CompanyEmail;
	}

}
