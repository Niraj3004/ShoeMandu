package com.shoesmandu.model;

import java.util.Date;

public class OrderModel {

	private int orderID;
	private int quantity;
	private String size;
	private double orderTotal;
	private String orderStatus;
	private Date orderDate;


	// Parameterized Constructor
	public OrderModel(int orderID, int quantity, String size, double orderTotal, String orderStatus, Date orderDate) {
		this.orderID = orderID;
		this.quantity = quantity;
		this.size = size;
		this.orderTotal = orderTotal;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
	}

	// Getters and Setters

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
}