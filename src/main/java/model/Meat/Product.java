package com.project.rest.webservice.Project.model.Meat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "mproduct")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String name;
	
	private Long companyID;
	
	@NotNull
	@DecimalMin(value = "0.1", inclusive = true)
	@DecimalMax(value = "50.9", inclusive = true)
	private BigDecimal cost;

	@OneToMany(
			mappedBy = "product",
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER
			)
	private Set<ProductOrder> prod;
	
	public Product() {}
	
	public Product(String name, BigDecimal cost, Long companyID) {
		this.name = name;
		this.cost = cost;
		this.companyID = companyID;
	}
	public Product(String name, BigDecimal cost) {
		this.name = name;
		this.cost = cost;
	}

	public long getProductId() {
		return id;
	}
	public String getProductName() {
		return this.name;
	}
	public void setProductName(String name) {
		this.name=name;
	}
	public BigDecimal getProductCost() {
		return this.cost;
	}
	public void setProductCost(BigDecimal cost) {
		this.cost=cost;
	}
	public long getCompanyId() {
		return this.companyID;
	}
	public void setCompanyId(Long companyID) {
		this.companyID=companyID;
	}
	public void setProductOrder(Set<ProductOrder> prod) {
	this.prod=prod;
}
	public Set<ProductOrder> getProductOrder(){
	return this.prod;
}

//	public void setProductOrders(Set<ProductOrder> productOrders) {
//		this.productOrders=productOrders;
//	}
//	public Set<ProductOrder> getProductOrders(){
//		return this.productOrders;
//	}
//	public List<ProductOrder> getProductOrders(){
//		return this.productOrders;
//	}
//	public ProductOrder getProdOrder() {
//		return this.getProdOrder();
//	}
//	public Company getMeatCompany() {
//		return company;
//	}
//	public void MeatCompany(Company company) {
//		this.company=company;
//	}

}
