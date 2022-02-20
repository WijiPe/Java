package com.wiji.productsandcatagories.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wiji.productsandcatagories.models.Catagory;
import com.wiji.productsandcatagories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findAll();
	
//	List<Product> findByBorrowerNull();
//	List<Product> findByBorrowerNotNull();
	List<Product> findByCatagoriesNotContains(Catagory catagory);
}
