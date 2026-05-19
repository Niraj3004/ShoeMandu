package com.shoesmandu.model;

/**
 * OrderModel represents an order placed by a customer
 * in the Shoesmandu system.
 * 
 * It stores order details, order item details,
 * and product information retrieved through table joins.
 * 
 * The model combines data from:
 * 1. Order table
 * 2. Order item table
 * 3. Product table
 * 
 * Product details are used only for displaying
 * order information and are not direct columns
 * of the order table.
 * 
 * @author Nikhil Sah
 */
public class OrderModel {

	// ORDER TABLE
	private int orderId;
	private int userId;
	private double totalAmount;
	private String orderStatus;
	private String shippingAddress;
	private String customerName;
	private String customerEmail;

	// ORDER ITEM TABLE
	private int orderItemId;
	private int productId;
	private int quantity;
	private double price;

	// PRODUCT TABLE (JOIN RESULT)
	private String productName;
	private String description;
	private String imageUrl;

	/**
	 * Default constructor for OrderModel.
	 */
	public OrderModel() {

	}

	/**
	 * @return the unique order ID
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the order ID to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the user ID associated with the order
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the user ID to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the total amount of the order
	 */
	public double getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the total amount to set
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the current order status
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus the order status to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * @return the shipping address of the customer
	 */
	public String getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * @param shippingAddress the shipping address to set
	 */
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	/**
	 * @return the unique order item ID
	 */
	public int getOrderItemId() {
		return orderItemId;
	}

	/**
	 * @param orderItemId the order item ID to set
	 */
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	/**
	 * @return the product ID associated with the order
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the product ID to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the quantity of products ordered
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the price of the product
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the product price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the name of the product
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the product name to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the description of the product
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the product description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the image URL of the product
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the image URL to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the customer's full name
	 */
	public String getCustomerName() {
	    return customerName;
	}

	/**
	 * @param customerName the customer name to set
	 */
	public void setCustomerName(String customerName) {
	    this.customerName = customerName;
	}

	/**
	 * @return the customer's email address
	 */
	public String getCustomerEmail() {
	    return customerEmail;
	}

	/**
	 * @param customerEmail the customer email to set
	 */
	public void setCustomerEmail(String customerEmail) {
	    this.customerEmail = customerEmail;
	}
}