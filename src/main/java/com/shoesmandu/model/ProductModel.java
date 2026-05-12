package com.shoesmandu.model;

public class ProductModel {

	private int productId;
	private String productName;
	private String brand;
	private String category;
	private String description;
	private double price;
	private int stock;
	private String imageUrl;
	
	

	public ProductModel(int productId, String productName, String brand, String category, String description,
			double price, int stock, String imageUrl) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.brand = brand;
		this.category = category;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.imageUrl = imageUrl;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}