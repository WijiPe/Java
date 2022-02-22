package com.wiji.projectmanager.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wiji.projectmanager.models.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
		
		List<Task> findAll();


}
