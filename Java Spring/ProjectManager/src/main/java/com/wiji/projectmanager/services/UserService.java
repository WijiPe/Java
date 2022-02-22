package com.wiji.projectmanager.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.wiji.projectmanager.models.LoginUser;
import com.wiji.projectmanager.models.User;
import com.wiji.projectmanager.repository.UserRepository;



@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
    public User register(User newUser, BindingResult result) {

    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
        

    	if(potentialUser.isPresent()) { 
    		result.rejectValue("email", "unique", "This email is already in use!");
    	}
    	

    	if(!newUser.getPassword().equals(newUser.getConfirm())) { 
    		result.rejectValue("confirm", "Matches", "The confirmed password does not match.");
    	}
    	

    	if(result.hasErrors()) {
    		return null;
    	}

    

    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	return userRepo.save(newUser);
        
    }
    
    
    public User login(LoginUser newLogin, BindingResult result) {

    Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
    	
 
	if(!potentialUser.isPresent()) { 
		result.rejectValue("email", "unique", "Unknown email");
		return null;
	}

	User user = potentialUser.get();
	

	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
	    result.rejectValue("password", "Matches", "Invalid Password!");
	}
	

	if(result.hasErrors()) {
		return null;
	}
 	

	return user;
    }
    
    public User findOneUser(Long id){
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}else {
    		return null;
    	}
	}
}


