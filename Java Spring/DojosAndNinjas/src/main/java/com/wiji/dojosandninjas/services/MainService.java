package com.wiji.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiji.dojosandninjas.models.Dojo;
import com.wiji.dojosandninjas.models.Ninja;
import com.wiji.dojosandninjas.repository.DojoRepository;
import com.wiji.dojosandninjas.repository.NinjaRepository;


@Service
public class MainService {
	
	@Autowired
	private NinjaRepository ninjaRepo;
	
	@Autowired
	private DojoRepository dojoRepo;
	
	// create users
	public Dojo saveDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
		
	public Ninja saveNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
		
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
		
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
	public Dojo findOneDojo(Long id){
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}else {
    		return null;
    	}
	}
	
	 public Dojo createDojo(Dojo dojo) {
	     return dojoRepo.save(dojo);
	 }
	 
	 public Ninja createNinja(Ninja ninja) {
	     return ninjaRepo.save(ninja);
	 }
			
}
