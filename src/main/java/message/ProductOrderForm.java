package com.project.rest.webservice.Project.message;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.project.rest.webservice.Project.model.Meat.Order;
import com.project.rest.webservice.Project.model.Meat.Product;

public class ProductOrderForm {
	
	@NotNull
	@Min(value = 1)
	@Max(value = 100)
	private Long quantity;
	
	private Order order;
	private Product product;

	
	@DecimalMin(value = "0.1", inclusive = true)
	@DecimalMax(value = "500.9", inclusive = true)
	private BigDecimal cost;
	
	private Long productID;
		
//	public BigDecimal getProductOrderCost() {
//		return product.getProductCost();
//	}
	public void setQty(Long quantity) {
	this.quantity=quantity;
	}
	public Long getQuantity() {
		return this.quantity;
	}
	
	public void setOrder(Order order) {
		this.order=order;
	}
	public Order getOrder() {
		return this.order;
	}
	
	public Long getOrderID() {
		Long id;
		id = this.order.getID();
		return id;
	}
	public void setProduct(Product product) {
		this.product=product;
	}
	public Product getProduct() {
		return this.product;
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
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
//	public BigDecimal getCost() {
//		return this.cost;
//	}
//	public void setCost(Product product) {
//		this.cost = this.product.getProductCost().multiply(new BigDecimal(this.quantity));
//	}
	public BigDecimal getCost() {
		return this.cost;
	}
	public void setTesterID(Long productID) {
		this.productID = productID;
	}
	public Long getTesterID() {
		return this.productID;
	}
	
//	public void setProductId(Long productId) {
//		this.productId=productId;
//	}
//	public Long getProdId() {
//		return this.productId;
//	}
//	public void setOrderId(Long orderId) {
//		this.orderId=orderId;
//	}
//	public Long getOrderId() {
//		return this.orderId;
//	}
//	public BigDecimal getProductCost() {
//		return this.product.getProductCost();
//	}

//	public BigDecimal calcOrderCost(Product p) {
//		BigDecimal qty = new BigDecimal(Long.toString(quantity));
//		this.orderCost = p.getProductCost().multiply(qty);
//		return this.orderCost;
//	}
//	public BigDecimal getOrderCost(Product p) {
//		p.getProductCost();
//		return this.orderCost;
//	}
	
	

}
