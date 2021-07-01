package com.brian.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.brian.productsandcategories.models.Category;
import com.brian.productsandcategories.models.Product;
import com.brian.productsandcategories.repositories.CategoryRepo;
import com.brian.productsandcategories.repositories.ProductRepo;

@Service
public class CategoryService {
private final CategoryRepo categoryRepo;
private final ProductRepo productRepo;
	
	public CategoryService(CategoryRepo categoryRepo, ProductRepo productRepo) {
		this.categoryRepo = categoryRepo;
		this.productRepo = productRepo;
	}
	
	
	
	public List<Category> allCategories() {
		return categoryRepo.findAll();
	}
	public Category createCategory (Category p) {
		return categoryRepo.save(p);
	}
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	public Category updateCategory(Category Category) {
		return categoryRepo.save(Category);
	}
	public void deleteCategory(Long id) {
		Category Category = findCategory(id);
		categoryRepo.delete(Category);
	}
	public Category addProduct(Long product_id, Long category_id) {
		Product thisProduct = productRepo.findById(product_id).orElse(null);
		Category thisCategory = categoryRepo.findById(category_id).orElse(null);
		thisCategory.getProducts().add(thisProduct);
		return categoryRepo.save(thisCategory);
	}
}
