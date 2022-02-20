package com.wiji.productsandcatagories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiji.productsandcatagories.models.Catagory;
import com.wiji.productsandcatagories.models.Product;
import com.wiji.productsandcatagories.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> allProducts(){
		return productRepository.findAll();
	}
	
	public Product oneProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}else {
			return null;
		}
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
		
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
		
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
	
	public List<Product> findProductOfCatagory(Catagory category){
		return productRepository.findByCatagoriesNotContains(category);
	}


}
