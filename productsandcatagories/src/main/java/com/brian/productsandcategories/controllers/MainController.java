package com.brian.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.brian.productsandcategories.models.Category;
import com.brian.productsandcategories.models.Product;
import com.brian.productsandcategories.services.CategoryService;
import com.brian.productsandcategories.services.ProductService;

@Controller
public class MainController {
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public MainController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("/products/new")
		public String productIndex(Model model) {
		List<Product> products = productService.allProducts();
		model.addAttribute("products", products);
		model.addAttribute("product", new Product());
		return "productNew.jsp";
	}
	
	@RequestMapping(value="/products/create", method=RequestMethod.POST)
		public String newProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
			if(result.hasErrors()) {
				return "productNew.jsp";
			} else {
				productService.createProduct(product);
				List<Product> products = productService.allProducts();
				Long newProductId = products.get(products.size()-1).getId();
				return "redirect:/products/"+ newProductId;
			}
	}
	@RequestMapping("/products/{id}")
		public String showProduct(@PathVariable("id") Long id, @Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
			Product thisProduct = productService.findProduct(id);
			List<Category> categories = categoryService.allCategories();
			model.addAttribute("product", thisProduct);
			model.addAttribute("categories", categories);
			return "productDetails.jsp";
	}
	@RequestMapping(value="/products/{id}/addcat", method=RequestMethod.POST)
	public String addCategory(@PathVariable("id") Long id, @RequestParam("category_id") Long category_id) {
		productService.addCategory(id, category_id);
		return "redirect:/products/" + id;
	}

	@RequestMapping("/categories/new")
		public String categoryIndex(Model model) {
		List<Category> categories = categoryService.allCategories();
		model.addAttribute("categories", categories);
		model.addAttribute("category", new Category());
		return "categoryNew.jsp";
	}
	
	@RequestMapping(value="/categories/create", method=RequestMethod.POST)
		public String newCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
			if(result.hasErrors()) {
				return "categoryNew.jsp";
			} else {
				categoryService.createCategory(category);
				List<Category> categories = categoryService.allCategories();
				Long newCategoryId = categories.get(categories.size()-1).getId();
				return "redirect:/categories/" + newCategoryId;
			}
	}
	
	@RequestMapping("/categories/{id}")
		public String showCategory(@PathVariable("id") Long id, @Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
			Category thisCategory = categoryService.findCategory(id);
			List<Product> products = productService.allProducts();
			model.addAttribute("category", thisCategory);
			model.addAttribute("product", products);
			return "categoryDetails.jsp";
	}
	 
}
