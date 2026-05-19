package com.shoesmandu.model;

/**
 * CartModel represents a shopping cart item in the Shoesmandu system.
 * 
 * It contains cart details such as cart ID, user ID, product ID,
 * quantity, and additional product information retrieved through joins.
 * 
 * Product details like name, description, price, and image URL
 * are used only for displaying cart information and are not direct
 * database columns of the cart table.
 * 
 * @author Nikhil Sah
 */
public class CartModel {

	private int cartId;
	private int userId;
	private int productId;
	private int quantity;

	// PRODUCT DETAILS (JOIN RESULT ONLY - NOT DB COLUMN)
	private String productName;
	private String description;
	private double price;
	private String imageUrl;

	/**
	 * Default constructor for CartModel.
	 */
	public CartModel() {
	}

	/**
	 * Parameterized constructor for CartModel.
	 * 
	 * @param cartId the unique cart ID
	 * @param userId the ID of the user
	 * @param productId the ID of the product
	 * @param quantity the quantity of the product
	 * @param productName the name of the product
	 * @param description the description of the product
	 * @param price the price of the product
	 * @param imageUrl the image URL of the product
	 */
	public CartModel(int cartId, int userId, int productId, int quantity, String productName,
			String description, double price, String imageUrl) {

		super();

		this.cartId = cartId;
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the unique cart ID
	 */
	public int getCartId() {
		return cartId;
	}

	/**
	 * @param cartId the cart ID to set
	 */
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return the ID of the user associated with the cart
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
	 * @return the ID of the product in the cart
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
	 * @return the quantity of the product in the cart
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
}