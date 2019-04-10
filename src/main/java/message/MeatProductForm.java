package com.project.rest.webservice.Project.message;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MeatProductForm {
	
	@NotBlank
	@Size(min=3, max=60)
	private String name;
	
	@NotNull
	@DecimalMin(value = "0.1", inclusive = true)
	@DecimalMax(value = "50.9", inclusive = true)
	private BigDecimal cost;
	
	@Min(value = 1)
	@Max(value = 100)
	private Long number;
		
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name=name;
	}

	public BigDecimal getCost() {
		return this.cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost=cost;
	}
	public Long getCompID() {
		return this.number;
	}
	public void setCompID(Long number) {
		this.number=number;
	}
	
//	public <Product>products getProducts(){
//		return products;
//	}
}
