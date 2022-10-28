package com.amazon.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name="product")
@Schema(description = "Product Model")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Id Auto generation ")
	private int product_id;
	@Schema(description = "Product Name",required = true)
	private String product_name;
	@Schema(description = "Brand Name",required = true)
	private String brand;
	@Schema(description = "Price of product",required = true)
	private double price;
	@Schema(description = "Product Stock",required = true)
	private int stock;
	@Schema(description = "Rating should be less than 5",required = true)
	private int ratings;

	@JsonBackReference
	@OneToMany(mappedBy = "product",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Order> order=new ArrayList<Order>();
	public Product() {
		
	}
	public Product(int product_id, String product_name, String brand, double price, int stock, int ratings,
			List<Order> order) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.brand = brand;
		this.price = price;
		this.stock = stock;
		this.ratings = ratings;
		this.order = order;
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
	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	
}
