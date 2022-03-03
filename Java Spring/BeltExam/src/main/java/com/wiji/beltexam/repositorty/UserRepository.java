package com.wiji.beltexam.repositorty;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.wiji.beltexam.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	Optional<User> findByEmail(String email);

}
