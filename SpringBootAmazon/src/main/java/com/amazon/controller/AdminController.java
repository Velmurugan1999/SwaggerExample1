package com.amazon.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.dtos.ProductDto;
import com.amazon.dtos.UserDto;
import com.amazon.models.Order;
import com.amazon.models.Product;
import com.amazon.models.User;
import com.amazon.serivce.AdminService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/amazon/admin")
@Tag(name = "Admin Controller",description = "Operations performe by admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@GetMapping("/alluser")
	@Operation(summary = "Get all User details",description = "Get all User details")
	public ResponseEntity<List<User>> allUser(){
		return new ResponseEntity<List<User>> (adminService.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/allproduct")
	@Operation(summary = "Get all product details",description = "Get all Product details")
	public ResponseEntity<List<Product>> getAllproduct(){
		return new ResponseEntity<List<Product>>(adminService.getAllProducts(),HttpStatus.OK);
	}
	
	@GetMapping("/allorder")
	@Operation(summary = "Get all order details",description = "Get all Order details")
	public ResponseEntity<List<Order>> getAllOrder(){
		return new  ResponseEntity<List<Order>>(adminService.getAllOrders(),HttpStatus.OK);
	}
	
	@PostMapping("/user")
	@Operation(summary = "Insert new User",description = "Insert new user")
	public ResponseEntity<User> insertUser(@RequestBody UserDto userDto)
	{
		return new ResponseEntity<User>(adminService.insertUser(userDto),HttpStatus.OK);
	}
	
	@PostMapping("/product")
	@Operation(summary = "Insert new product",description ="Insert new product")
	public ResponseEntity<Product> insertProduct(@RequestBody ProductDto productDto)
	{
		return new  ResponseEntity<Product>(adminService.insertProduct(productDto),HttpStatus.OK);
	}
	
	@PutMapping("/delivered/{order_id}")
	@Operation(summary = "Update Order Status as Delivered",description ="Update Order Status as Delivered by Order ID")
	public ResponseEntity<Order> deliverdOrder(@PathVariable int order_id) throws Exception
	{
		return new  ResponseEntity<Order>( adminService.updateOrder(order_id),HttpStatus.OK);
	}
	
	@PutMapping("/updatestock/{product_id}/{count}")
	@Operation(summary = "Update Product stock",description ="Update Product stock by product ID")
	public  ResponseEntity<Product> updateStock(@PathVariable int product_id,@PathVariable int count) throws Exception
	{
		return  new ResponseEntity<Product>(adminService.updateProductCount(product_id, count),HttpStatus.OK);
	}
	
	@DeleteMapping("/product/{product_id}")
	@Operation(summary = "Delete Product4",description ="Delete Product by product ID")
	public ResponseEntity<String> deleteProduct(@PathVariable int product_id) throws Exception
	{
		adminService.deleteProduct(product_id);
		return new  ResponseEntity<String>("Deleted",HttpStatus.OK);
	}
}
