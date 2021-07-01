package com.brian.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brian.productsandcategories.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long>{
	
	List<Product> findAll();
	
	List<Product> findByNameContaining(String search);
}
