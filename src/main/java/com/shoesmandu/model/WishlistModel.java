package com.shoesmandu.model;

/**
 * WishlistModel represents a wishlist item
 * in the Shoesmandu system.
 * 
 * It stores wishlist details along with
 * product information retrieved through joins.
 * 
 * The model contains:
 * 1. Wishlist table data
 * 2. Product details for display purposes
 * 
 * Product information such as product name,
 * description, price, and image URL are
 * join results and not direct columns
 * of the wishlist table.
 * 
 * @author Nikhil Sah
 */
public class WishlistModel {

	// WISHLIST TABLE COLUMNS
	private int wishlistId;
	private int userId;
	private int productId;

	// PRODUCT DETAILS (JOIN RESULT ONLY)
	private String productName;
	private String description;
	private double price;
	private String imageUrl;

	/**
	 * Default constructor for WishlistModel.
	 */
	public WishlistModel() {

	}

	/**
	 * Parameterized constructor for WishlistModel.
	 * 
	 * @param wishlistId the unique wishlist ID
	 * @param userId the ID of the user
	 * @param productId the ID of the product
	 * @param productName the name of the product
	 * @param description the description of the product
	 * @param price the price of the product
	 * @param imageUrl the image URL of the product
	 */
	public WishlistModel(int wishlistId, int userId, int productId,
			String productName, String description,
			double price, String imageUrl) {

		this.wishlistId = wishlistId;
		this.userId = userId;
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the unique wishlist ID
	 */
	public int getWishlistId() {
		return wishlistId;
	}

	/**
	 * @param wishlistId the wishlist ID to set
	 */
	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}

	/**
	 * @return the user ID associated with the wishlist
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
	 * @return the product ID associated with the wishlist
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