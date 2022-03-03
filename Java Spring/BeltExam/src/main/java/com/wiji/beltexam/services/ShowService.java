package com.wiji.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.wiji.beltexam.models.Show;
import com.wiji.beltexam.repositorty.ShowRepository;

@Service
public class ShowService {
	
	@Autowired
	private ShowRepository showRepository;
	
	public List<Show> allShows(){
		return showRepository.findAll();
	}
	
	public Show oneShow(Long id) {
		Optional<Show> optionalShow = showRepository.findById(id);
		if(optionalShow.isPresent()) {
			return optionalShow.get();
		}else {
			return null;
		}
	}
	
	public Show createShow(Show show) {
		return showRepository.save(show);
	}
	
	public Show updateShow(Show show) {
		return showRepository.save(show);
	}
	
	public void deleteShow(Long id) {
		showRepository.deleteById(id);
	}
	
	 public Show createShow2(Show show, BindingResult result) {

	    	Optional<Show> potentialShow = showRepository.findByTitle(show.getTitle());
	        

	    	if(potentialShow.isPresent()) { 
	    		result.rejectValue("title", "unique", "This title is already in data!");
	    	}
	
	    	if(result.hasErrors()) {
	    		return null;
	    	}

	    	return showRepository.save(show);
	    	
	 }
	 

}
