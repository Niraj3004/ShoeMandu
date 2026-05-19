package com.shoesmandu.model;

/**
 * ProductModel represents a product available
 * in the Shoesmandu system.
 * 
 * It stores product-related information such as
 * product ID, name, brand, category, description,
 * price, stock quantity, and image URL.
 * 
 * This model is used for managing and displaying
 * product details throughout the application.
 * 
 * @author Nikhil Sah
 */
public class ProductModel {

	// VARIABLES

	private int productId;

	private String productName;

	private String brand;

	private String category;

	private String description;

	private double price;

	private int stock;

	private String imageUrl;

	/**
	 * Default constructor for ProductModel.
	 */
	public ProductModel() {

	}

	/**
	 * Parameterized constructor for ProductModel.
	 * 
	 * @param productId the unique product ID
	 * @param productName the name of the product
	 * @param brand the brand of the product
	 * @param category the category of the product
	 * @param description the description of the product
	 * @param price the price of the product
	 * @param stock the available stock quantity
	 * @param imageUrl the image URL of the product
	 */
	public ProductModel(int productId, String productName, String brand,
			String category, String description,
			double price, int stock, String imageUrl) {

		this.productId = productId;
		this.productName = productName;
		this.brand = brand;
		this.category = category;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the unique product ID
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
	 * @return the brand of the product
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the product brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the category of the product
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the product category to set
	 */
	public void setCategory(String category) {
		this.category = category;
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
	 * @return the available stock quantity
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock the stock quantity to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
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