package com.wiji.projectmanager.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wiji.projectmanager.models.Project;
import com.wiji.projectmanager.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	
	List<Project> findAll();
	List<Project> findByUsersNotContains(User user);
	List<Project> findByUsersContaining(User user);
}
