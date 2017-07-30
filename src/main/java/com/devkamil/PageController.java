package com.devkamil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.devkamil.Task;

@Controller
public class PageController {
	
	@Autowired
	public pl.devkamil.TaskRepository taskRepository;
	
	
	@RequestMapping("/")
	@ResponseBody
	public String mainPage() {
		return "Hello World!";
	}
	
	@RequestMapping("/hello")
	@ResponseBody
	public String pageTwo() {
		return "Hi!";
	}
	
	
	@RequestMapping("/db")
	@ResponseBody
	public String testMethod(){
		StringBuilder response = new StringBuilder();
		
		Task task = new Task()
				.withName("Task 1")
				.withDescription("Test task")
				.withBudget(123.55)
				.withDone(true);
		taskRepository.save(task);
		
		for(Task i: taskRepository.findAll()) {
			response.append(i).append("<br>");
		}
		
		return response.toString();
	}

}
