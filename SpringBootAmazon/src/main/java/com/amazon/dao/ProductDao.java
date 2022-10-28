package com.amazon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amazon.models.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{
	@Query("select p from Product p where p.product_name=?1")
	List<Product> getProductsByName(String product_name);
	
	@Query("select p from Product p where p.brand=?1")
	List<Product> getProductsByBrand(String brand);
}
