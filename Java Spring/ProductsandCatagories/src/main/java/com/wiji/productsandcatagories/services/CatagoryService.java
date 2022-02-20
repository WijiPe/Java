package com.wiji.productsandcatagories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiji.productsandcatagories.models.Catagory;
import com.wiji.productsandcatagories.models.Product;
import com.wiji.productsandcatagories.repository.CatagoryRepository;

@Service
public class CatagoryService {
	@Autowired
	private CatagoryRepository catagoryRepository;
	
	public List<Catagory> allCatagorys(){
		return catagoryRepository.findAll();
	}
	
	public Catagory oneCategory(Long id) {
		Optional<Catagory> optionalCatagory = catagoryRepository.findById(id);
		if(optionalCatagory.isPresent()) {
			return optionalCatagory.get();
		}else {
			return null;
		}
	}

	public Catagory createCatagory(Catagory catagory) {
		return catagoryRepository.save(catagory);
	}
		
	public Catagory updateCategory(Catagory catagory) {
		return catagoryRepository.save(catagory);
	}
		
	public void deleteCatagory(Long id) {
		catagoryRepository.deleteById(id);
	}
	
	public List<Catagory> findCategoryOfProduct(Product product){
		return catagoryRepository.findByProductsNotContains(product);
	}
}
