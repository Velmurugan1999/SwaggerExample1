package com.amazon.serivce;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.dao.OrderDao;
import com.amazon.dao.ProductDao;
import com.amazon.dao.RoleDao;
import com.amazon.dao.UserDao;
import com.amazon.dtos.ProductDto;
import com.amazon.dtos.UserDto;
import com.amazon.exceptions.OrderNotFoundException;
import com.amazon.exceptions.ProductNotFoundException;
import com.amazon.models.Order;
import com.amazon.models.Product;
import com.amazon.models.User;

@Service
public class AdminService {
	@Autowired
	OrderDao odao;
	@Autowired
	ProductDao pdao;
	@Autowired
	RoleDao rdao;
	@Autowired
	UserDao udao;
	
	public List<User> getAllUsers(){
		return udao.findAll();
	}
	
	public List<Order> getAllOrders(){
		return odao.findAll();
	}
	
	public List<Product> getAllProducts(){
		return pdao.findAll();
	}
	
	public User insertUser(UserDto dto)
	{
		User user=new User(dto.getUname(),dto.getMobile(),dto.getEmailid(),dto.getAddress(),new ArrayList<Order>(),rdao.findById(2).get());
		return udao.save(user);
	}
	
	public Product insertProduct(ProductDto dto)
	{
		Product product=new Product(0, dto.getProduct_name(),dto.getBrand(),dto.getPrice(),dto.getStock(),dto.getRatings(),new ArrayList<Order>());
		return pdao.save(product);
	}
	
	public Order updateOrder(int oid) throws Exception
	{
		Order order=odao.findById(oid).orElseThrow(()->new OrderNotFoundException("No Order with given Id"));
		order.setStatus("Delivered");
		return odao.save(order);
	}
	
	public Product updateProductCount(int pid,int count) throws Exception
	{
		Product product=pdao.findById(pid).orElseThrow(()->new ProductNotFoundException("No Product with given Id"));
		product.setStock(product.getStock()+count);
		return pdao.save(product);
	}
	
	public void deleteProduct(int pid) throws Exception
	{
		Product product=pdao.findById(pid).orElseThrow(()->new ProductNotFoundException("No Product with given Id"));
		product.getOrder().clear();
		pdao.delete(product);
	}
	
}
