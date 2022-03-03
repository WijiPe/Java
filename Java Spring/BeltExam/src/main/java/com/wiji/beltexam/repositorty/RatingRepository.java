package com.wiji.beltexam.repositorty;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wiji.beltexam.models.Rating;

public interface RatingRepository extends CrudRepository<Rating, Long> {
	List<Rating> findAll();
	
//	List<Rating> findByRatingOrderByRatingAsc(Float float1);
	
	List<Rating> findByShow_idOrderByRateDesc(Long id);
}
