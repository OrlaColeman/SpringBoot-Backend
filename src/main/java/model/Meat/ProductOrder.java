package com.project.rest.webservice.Project.model.Meat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "productOrder")
public class ProductOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private Long quantity;
	
	@NotNull
	@DecimalMin(value = "0.1", inclusive = true)
	@DecimalMax(value = "500.9", inclusive = true)
	private BigDecimal cost;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private Order order;
	
	public ProductOrder() {}
	
	public ProductOrder(Long quantity) {
		this.quantity=quantity;
	}
	
	public Long getID() {
		return this.id;
	}
		
	public void setQuantity(Long quantity) {
		this.quantity=quantity;
	}
	public Long getQuantity() {
		return this.quantity;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public Long getOrderID() {
		Long id;
		id = this.order.getID();
		return id;
	}
	
	public void setProduct(Product product) {
		this.product=product;
	}
	
	public Long getProductID() {
		Long id;
		id = this.product.getProductId();
		return id;
	}
	public String getProductName() {
		String name;
		name = this.product.getProductName();
		return name;
	}
	
//	public void setCost(BigDecimal cost) {
//		this.cost=cost;
//	}
//	public BigDecimal getProductCost() {
//		BigDecimal x;
//		x = this.product.getProductCost().multiply(new BigDecimal(this.quantity));
//		return x;
//	}
	
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public BigDecimal getCost() {
		return this.cost;
	}
//	public Long calcOrderID(Order order) {
//		Long ID;
//		ID = this.order.getID();
//		return ID;
//	}

//	public Order getOrderId() {
//		return this.order;
//	}
//	public Long getOrder() {
//		return this.ID
//	}
//	public Product getProduct() {
//		return this.product;
//	}
//	public BigDecimal getProductCost() {
//		return this.product.getProductCost();
//	}


//	public void setOrderCost(BigDecimal orderCost) {
//		this.orderCost=orderCost;
//	}
	
//	public BigDecimal getOrderCost() {
//		return this.orderCost;
//	}
//public void setProdID(Long id) {}
//	public void setOrderID(Long id) {
//		
//	}
//	public Long getOrderID() {
//		return id;
//	}
	

}
