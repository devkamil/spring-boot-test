package pl.devkamil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		
		modelAndView.addObject("greetings", "Hello world from variable!");
		modelAndView.addObject("greetingsArray", new String[] {"Hello", "World", "!"});
		
		return modelAndView;
	}

}
