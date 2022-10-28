package com.amazon.serivce;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.dao.OrderDao;
import com.amazon.dao.ProductDao;
import com.amazon.dao.RoleDao;
import com.amazon.dao.UserDao;
import com.amazon.dtos.UserDto;
import com.amazon.exceptions.OrderNotFoundException;
import com.amazon.exceptions.ProductNotFoundException;
import com.amazon.exceptions.UserNotFoundException;
import com.amazon.models.Order;
import com.amazon.models.Product;
import com.amazon.models.User;

@Service
public class UserService {
	@Autowired
	OrderDao odao;
	@Autowired
	ProductDao pdao;
	@Autowired
	RoleDao rdao;
	@Autowired
	UserDao udao;

	public List<Product> getAllProduct() {
		return pdao.findAll();
	}

	public User getUserByid(int uid) throws Exception {
			return udao.findById(uid).orElseThrow(() -> new UserNotFoundException("No user with given Id"));
	}

	public Order getOrderbyId(int oid) throws Exception {
		Order o = odao.findById(oid).orElseThrow(() -> new OrderNotFoundException("No order with given Id"));
		
		return o;
	}

	public Order newOrder(int pid, int uid, int count) throws Exception {
		Product product = pdao.findById(pid).orElseThrow(() -> new ProductNotFoundException("No product with given Id"));
		User user = udao.findById(uid).orElseThrow(() -> new UserNotFoundException("No user with given Id"));
		if (user != null && product != null) {
			if (product.getStock() - count >= 0) {
				product.setStock(product.getStock() - count);
				pdao.save(product);
				Order o_obj = new Order(user, product, product.getProduct_name(), (new Date()).toString(), "Ordered",
						count);
				return odao.save(o_obj);
			} else {
				System.out.println("Out of Stock");
				return null;
			}
		} else {
			return null;
		}
	}

	public Order cancelOrder(int oid) throws OrderNotFoundException {
		
		Order order = odao.findById(oid).orElseThrow(()->new OrderNotFoundException("No Order with given Id"));
		order.setStatus("Cancelled");
		order.setDate((new Date()).toString());
		Product product = order.getProduct();
		product.setStock(product.getStock() + order.getCount());
		pdao.save(product);
		return odao.save(order);

	}

	public List<Order> userOrders(int uid) {
		//return udao.findById(uid).orElseThrow(() -> new EntityNotFoundException("No user with given Id")).getOrders();
		return odao.findbyUserId(uid);
	}

	public User updateUser(UserDto userDto) throws UserNotFoundException {
		System.out.println(userDto.getUserid());
		User old = udao.findById(userDto.getUserid()).orElseThrow(() -> new UserNotFoundException("No user with given Id"));
		User user = new User(userDto.getUserid(), userDto.getUname(), userDto.getMobile(), userDto.getEmailid(),
				userDto.getAddress(), old.getOrders(), old.getRole());
		return udao.save(user);

	}
	
	public List<Product> getProductsByName(String product_name)
	{
		return pdao.getProductsByName(product_name);
	}
	
	public List<Product> getproductsByBrand(String brand)
	{
		return pdao.getProductsByBrand(brand);
	}
}
