package com.devkamil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
	
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
	

}
