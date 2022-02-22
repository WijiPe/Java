package com.wiji.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiji.projectmanager.models.Project;
import com.wiji.projectmanager.models.User;
import com.wiji.projectmanager.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public List<Project> allProjects(){
		return projectRepository.findAll();
	}
	
	public Project oneProject(Long id) {
		Optional<Project> optionalProject = projectRepository.findById(id);
		if(optionalProject.isPresent()) {
			return optionalProject.get();
		}else {
			return null;
		}
	}
	
	public Project createProject(Project project) {
		return projectRepository.save(project);
	}
	
	public Project updateProject(Project project) {
		return projectRepository.save(project);
	}
	
	public void deleteProject(Long id) {
		projectRepository.deleteById(id);
	}
	
	
	public List<Project> findByUsersNotContains(User user){
		return projectRepository.findByUsersNotContains(user);
	}
	
	public List<Project> findByUsersContaining(User user){
		return projectRepository.findByUsersContaining(user);
	}
	
}
