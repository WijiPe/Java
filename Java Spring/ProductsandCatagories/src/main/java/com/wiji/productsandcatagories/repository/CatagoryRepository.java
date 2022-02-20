package com.wiji.productsandcatagories.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wiji.productsandcatagories.models.Catagory;
import com.wiji.productsandcatagories.models.Product;

@Repository
public interface CatagoryRepository extends CrudRepository<Catagory, Long> {
	
	List<Catagory> findAll();
	
// Retrieves a list of all categories for a particular product
    List<Catagory> findAllByProducts(Product product);
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<Catagory> findByProductsNotContains(Product product);


}
