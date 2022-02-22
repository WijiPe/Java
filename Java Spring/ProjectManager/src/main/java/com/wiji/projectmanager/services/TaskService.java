package com.wiji.projectmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiji.projectmanager.models.Task;
import com.wiji.projectmanager.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> allTasks(){
		return taskRepository.findAll();
	}
	
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}

}
