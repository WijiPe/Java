package com.wiji.beltexam.repositorty;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.wiji.beltexam.models.Show;

public interface ShowRepository extends CrudRepository<Show, Long> {
	
	List<Show> findAll();
//	List<Project> findByUsersNotContains(User user);
//	List<Project> findByUsersContaining(User user);

	Optional<Show> findByTitle(String title);

}
