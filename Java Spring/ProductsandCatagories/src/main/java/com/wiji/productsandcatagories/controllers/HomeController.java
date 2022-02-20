package com.wiji.productsandcatagories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wiji.productsandcatagories.models.Catagory;
import com.wiji.productsandcatagories.models.Product;
import com.wiji.productsandcatagories.services.CatagoryService;
import com.wiji.productsandcatagories.services.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CatagoryService catagoryService;
	
    @GetMapping("/product/new")
    public String dashboard( @ModelAttribute("product")Product product) {
    	return "productForm.jsp";
    }
    
    @PostMapping("/submitForm")
	public String submitForm(@Valid @ModelAttribute("product")Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "productForm.jsp";
		}else {
			Product newProduct = productService.createProduct(product);
			return "redirect:/products/"+newProduct.getId();
		}
	}
    
	@GetMapping("/products/{id}")
	public String showOneProduct(@PathVariable("id")Long id, Model model) {
		Product product = productService.oneProduct(id);
		List<Catagory> categories =  catagoryService.findCategoryOfProduct(product);
		model.addAttribute("product", product);
		model.addAttribute("categories", categories);
		return "showProduct.jsp";
	}
	
	@PutMapping("/products/{id}")
	public String categoryOfProduct(@PathVariable("id")Long id, @RequestParam("categoryId")Long categoryId, Model model) {
		Product product = productService.oneProduct(id);
		Catagory updateCategory = catagoryService.oneCategory(categoryId);
		product.getCatagories().add(updateCategory);
		productService.updateProduct(product);
		return "redirect:/products/"+id;
	}
	
	@GetMapping("/category/new")
    public String categoryForm( @ModelAttribute("catagory")Catagory catagory) {
    	return "categoryForm.jsp";
    }
    
    @PostMapping("/submitCategoryForm")
	public String submitCategoryForm(@Valid @ModelAttribute("catagory")Catagory catagory, BindingResult result) {
		if(result.hasErrors()) {
			return "categoryForm.jsp";
		}else {
			Catagory newCatagory = catagoryService.createCatagory(catagory);
			return "redirect:/categories/"+newCatagory.getId();
		}
	}
    
	@GetMapping("/categories/{id}")
	public String showOneCategory(@PathVariable("id")Long id, Model model) {
		Catagory catagory = catagoryService.oneCategory(id);
		List<Product> products =  productService.findProductOfCatagory(catagory);
		model.addAttribute("catagory", catagory);
		model.addAttribute("products", products);
		return "showCategory.jsp";
	}
	
	@PutMapping("/categories/{id}")
	public String productOfCategory(@PathVariable("id")Long id, @RequestParam("productId")Long productId, Model model) {
		Product oneproduct = productService.oneProduct(productId);
		Catagory oneCategory = catagoryService.oneCategory(id);
		oneCategory.getProducts().add(oneproduct);
		catagoryService.updateCategory(oneCategory);
		return "redirect:/categories/"+id;
	}
}
