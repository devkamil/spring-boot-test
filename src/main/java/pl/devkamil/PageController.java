package pl.devkamil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
	
	@Autowired
	public TaskRepository taskRepository;
	
	
	@RequestMapping("/loggeduser")
	@ResponseBody
	public String loggedUserAction(){
		return "Hello User";
	}
	
	
	@RequestMapping("/h")
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
	
	
	@RequestMapping("/db2")
	@ResponseBody
	public String testMethod2(){
		StringBuilder response = new StringBuilder();
		
		response.append("<br><br>Tasks with 'done' set to true: <br>");
		for(Task i: taskRepository.findByDone(true)){
			response.append(i).append("<br>");
		}
		
		response.append("<br><br>Tasks with 'done' set to false: <br>");
		for(Task i: taskRepository.findByDone(false)){
			response.append(i).append("<br>");
		}
		
		response.append("<br><br>Task with name: Task 1 : <br>");
		for (Task i: taskRepository.findByName("Task 1")){
			response.append(i).append("<br>");
		}
		
		response.append("<br><br>Tasks with \"Do\" in description: <br>");
		for(Task i: taskRepository.getByDescriptionLike("Do")){
			response.append(i).append("<br>");
		}
		
		return response.toString();
	}

}
