package com.brian.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brian.productsandcategories.models.Category;
import com.brian.productsandcategories.models.Product;
import com.brian.productsandcategories.repositories.CategoryRepo;
import com.brian.productsandcategories.repositories.ProductRepo;

@Service
public class ProductService {
	private final ProductRepo productRepo;
	private final CategoryRepo categoryRepo;
	
	public ProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
	}
	public List<Product> allProducts() {
		return productRepo.findAll();
	}
	public Product createProduct (Product p) {
		return productRepo.save(p);
	}
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}
	public void deleteProduct(Long id) {
		Product product = findProduct(id);
		productRepo.delete(product);
	}
	public Product addCategory(Long product_id, Long category_id) {
		Product thisProduct = productRepo.findById(product_id).orElse(null);
		Category thisCategory = categoryRepo.findById(category_id).orElse(null);
		thisProduct.getCategories().add(thisCategory);
		return productRepo.save(thisProduct);
	}
}
