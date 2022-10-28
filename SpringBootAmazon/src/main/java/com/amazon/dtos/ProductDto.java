package com.amazon.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Product DTO for insert and update")
public class ProductDto {
	@Schema(description = "Product ID")
	private int product_id;
	@Schema(description = "Product name")
	private String product_name;
	@Schema(description = "Product Brand")
	private String brand;
	@Schema(description = "Price of Product")
	private double price;
	@Schema(description = "Product stock")
	private int stock;
	@Schema(description = "Rating Should be less than 5")
	private int ratings;
	
	public ProductDto() {
		
	}

	public ProductDto(int product_id, String product_name, String brand, double price, int stock, int ratings) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.brand = brand;
		this.price = price;
		this.stock = stock;
		this.ratings = ratings;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
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

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	
	
}
