package com.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.dtos.UserDto;
import com.amazon.models.Order;
import com.amazon.models.Product;
import com.amazon.models.User;
import com.amazon.serivce.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("amazon/user")
@Tag(name="User Controller",description = "Operations perfome by users")
public class UserController {
	@Autowired
	UserService userService;
	
	@Operation(summary = "Get all product details",description = "Get all product details")
	@GetMapping(path="/allproducts")
	public List<Product> allProduct(){
		return userService.getAllProduct();
	}
	
	
	@Operation(summary = "Get all order details by UserID",description = "Get all order details by user ID")
	@GetMapping(path="/allorders/{user_id}")
	public List<Order> allOrders(@PathVariable int user_id)
	{
		return userService.userOrders(user_id);
	}
	
	@Operation(summary = "User details",description = "Get User details by user ID")
	@GetMapping(path="/{user_id}")
	public User getUserByUserId(@PathVariable int user_id) throws Exception 
	{
		return userService.getUserByid(user_id);
	}
	
	@Operation(summary = "Order details by Order Id",description = "Get Order details by Order ID")
	@GetMapping(path="/order/{order_id}")
	public Order getOrderByOrderID(@PathVariable int order_id) throws Exception
	{
		return userService.getOrderbyId(order_id);
	}
	
	@Operation(summary = "Get Products By name",description = "Get products by product name")
	@GetMapping(path="/productbyname/{product_name}")
	public List<Product> getProductByProductName(@PathVariable String product_name)
	{
		return userService.getProductsByName(product_name);
	}
	
	@Operation(summary = "Get Products By brand",description = "Get products by brand name")
	@GetMapping(path="/productbybrand/{brand_name}")
	public List<Product> getProductByBrandName(@PathVariable String brand_name)
	{
		return userService.getproductsByBrand(brand_name);
	}
	
	@Operation(summary = "make new order",description = "Make new Order by user id and product id")
	@PostMapping(path="/neworder/{user_id}/{product_id}/{count}") 
	public Order newOrder(@PathVariable int user_id,@PathVariable int product_id,@PathVariable int count) throws Exception
	{
		return userService.newOrder(product_id, user_id, count);
	}
	
	@Operation(summary = "Cancel the Order",description="Cancel the order by Order ID")
	@PutMapping(path="/cancelorder/{order_id}")
	public Order cancelOrder(@PathVariable int order_id) throws Exception
	{
		return userService.cancelOrder(order_id);
	}
	
	@Operation(summary = "Update User details",description="Update User details")
	@PutMapping(path="/updateuser")
	public User updateUserDetails(@RequestBody UserDto dto) throws Exception
	{
		return userService.updateUser(dto);
	}
}
