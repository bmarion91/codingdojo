package com.brian.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brian.productsandcategories.models.Category;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long>{

	List<Category> findAll();
	
	List<Category> findByNameContaining(String search);
}
