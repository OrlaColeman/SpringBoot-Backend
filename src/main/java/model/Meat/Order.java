package com.project.rest.webservice.Project.model.Meat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;


@Entity 
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate = new Date();
	
	private Long userID;
	
//	@NotNull
//	@DecimalMin(value = "0.1", inclusive = true)
//	@DecimalMax(value = "50.9", inclusive = true)
//	private BigDecimal overallCost; 
	
//	@ManyToMany(fetch = FetchType.LAZY,
//			cascade = {
//					CascadeType.PERSIST,
//					CascadeType.MERGE
//			})
//	@JoinTable(name = "product_orders", 
//			joinColumns = {@JoinColumn(name= "order_id") },
//			inverseJoinColumns = {@JoinColumn(name = "mproduct_id") })
//	private Set<Product> products = new HashSet<>();
	
	
//	private Set<ProductOrder> productOrders;
	@OneToMany(
			mappedBy = "order",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
			)
	private Set<ProductOrder> prod;
	
	public Order() {}
	
	public Order(Long userID) {
		this.userID=userID;
	}
	public Order(Long userID, Set<ProductOrder> prod) {
		this.userID=userID;
		this.prod = prod;
	}
	
	//Stream.of(prod).distinct().collect(Collectors.toSet());
	//this.prod.forEach(x -> x.setOrder(this));
	
	public Long getID() {
		return this.id;
	}
	public void setUserID(Long userID) {
		this.userID=userID;
	}
	public Long getUserID() {
		return this.userID;
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

	
	
}
