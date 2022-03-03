package com.wiji.beltexam.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiji.beltexam.models.Rating;
import com.wiji.beltexam.repositorty.RatingRepository;


@Service
public class RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;
	
	public List<Rating> allRatings(){
		return ratingRepository.findAll();
	}
	
	public Rating createRating(Rating rating) {
		return ratingRepository.save(rating);
	}
	
	public List<Rating> findByShow_idOrderByRateDesc(Long id){
		return ratingRepository.findByShow_idOrderByRateDesc(id);
	}

	public Rating updateRating(Rating newRating) {
		return ratingRepository.save(newRating);
		
	}



}
