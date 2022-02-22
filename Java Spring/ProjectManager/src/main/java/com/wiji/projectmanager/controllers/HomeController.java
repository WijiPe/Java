package com.wiji.projectmanager.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


import com.wiji.projectmanager.models.Project;
import com.wiji.projectmanager.models.Task;
import com.wiji.projectmanager.models.User;
import com.wiji.projectmanager.services.ProjectService;
import com.wiji.projectmanager.services.TaskService;
import com.wiji.projectmanager.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UserService userService;
	
    @GetMapping("/project/new")
    public String dashboard( @ModelAttribute("project")Project project, HttpSession session) {
    	if(session.getAttribute("userId")==null) {
    		return "redirect:/";
    	}
    	return "projectForm.jsp";
    }
    
    @PostMapping("/submitProjectForm")
	public String submitForm(@Valid @ModelAttribute("project")Project project, BindingResult result, HttpSession session) {
    	if(session.getAttribute("userId")==null) {
    		return "redirect:/";
    	}
		if(result.hasErrors()) {
			return "projectForm.jsp";
		}else {
			Project newProject = projectService.createProject(project);
			projectService.updateProject(newProject);
			return "redirect:/dashboard";
		}
	}
    
    @GetMapping("/jointeam/{id}")
    public String joinTeam(@PathVariable("id")Long id, Model model, HttpSession session) {
    	if(session.getAttribute("userId")==null) {
    		return "redirect:/";
    	}
    	Project updateProject = projectService.oneProject(id);
    	User user = userService.findOneUser((Long)session.getAttribute("userId"));
    	updateProject.getUsers().add(user);
    	projectService.updateProject(updateProject);
    	return "redirect:/dashboard";
    }
    
    @GetMapping("/leaveteam/{id}")
    public String leaveTeam(@PathVariable("id")Long id, Model model, HttpSession session) {
    	Project updateProject = projectService.oneProject(id);
    	User user = userService.findOneUser((Long)session.getAttribute("userId"));
    	updateProject.getUsers().remove(user);
    	projectService.updateProject(updateProject);
    	return "redirect:/dashboard";
    }
    
	@GetMapping("/projects/edit/{id}")
	public String editForm(@PathVariable("id")Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		Project project = projectService.oneProject(id);
		model.addAttribute("project", project);
		return "edit.jsp";
	}
    
	@PutMapping("/projects/edit/{id}")
	public String edit(@PathVariable("id")Long id, @Valid @ModelAttribute("project")Project project, BindingResult result,  HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			Project updateProject = projectService.oneProject(id);
			User user = userService.findOneUser((Long)session.getAttribute("userId"));
	    	updateProject.getUsers().add(user);
	    	projectService.updateProject(updateProject);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/projects/details/{id}")
	public String edit(@PathVariable("id")Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		Project project = projectService.oneProject(id);
		model.addAttribute("project", project);
		return "projectDetails.jsp";
	}
	
	@GetMapping("/task/{id}")
	public String task(@PathVariable("id")Long id, HttpSession session, Model model, @ModelAttribute("task")Task task) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}

		Project project = projectService.oneProject(id);
		model.addAttribute("project", project);
		List<Task> tasks = taskService.allTasks();
		model.addAttribute("tasks", tasks);
		return "taskForm.jsp";
	}
	
	@PostMapping("/task/{id}")
	public String taskProcess(@PathVariable("id")Long id, @Valid @ModelAttribute("task")Task task, BindingResult result, HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			Project project = projectService.oneProject(id);
			model.addAttribute("project", project);
			List<Task> tasks = taskService.allTasks();
			model.addAttribute("tasks", tasks);
			return "taskForm.jsp";
		}
		taskService.createTask(task);
		return "redirect:/task/"+id;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProcess(@PathVariable("id")Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
    		return "redirect:/";
    	}
		projectService.deleteProject(id);
		return "redirect:/dashboard";
	}
}
