package com.amazon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amazon.models.Order;
@Repository
public interface OrderDao extends JpaRepository<Order, Integer>{
	@Query(value = "select o from Order o where o.user.userid=?1")
	List<Order> findbyUserId(int uid);
}
